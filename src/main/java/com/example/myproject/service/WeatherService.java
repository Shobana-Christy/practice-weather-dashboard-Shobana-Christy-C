package com.example.myproject.service;

import com.example.myproject.Weather;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private String API_KEY = "b6097eae87f649f84fadb04a799c16dc";

    public Weather getCurrentWeather(String city) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://api.openweathermap.org/data/2.5/weather?q="
                + city + "&appid=" + API_KEY + "&units=metric";

        // Get raw JSON string
        String json = restTemplate.getForObject(url, String.class);

        // Parse JSON
        JSONObject obj = new JSONObject(json);

        String cityName = obj.getString("name");
        double temp = obj.getJSONObject("main").getDouble("temp");
        int humidity = obj.getJSONObject("main").getInt("humidity");
        String description = obj.getJSONArray("weather")
                .getJSONObject(0)
                .getString("description");

        return new Weather(cityName, temp + "°C", description, humidity);

    }
}
