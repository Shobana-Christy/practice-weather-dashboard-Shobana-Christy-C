package com.example.myproject.controllers;

import com.example.myproject.Weather;
import com.example.myproject.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/current-weather")
    public Weather getCurrentWeather(@RequestParam String city) {
        return weatherService.getCurrentWeather(city);
    }

}
