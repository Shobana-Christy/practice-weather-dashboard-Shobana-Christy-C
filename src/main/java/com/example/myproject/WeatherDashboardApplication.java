package com.example.myproject;

import com.example.myproject.service.WeatherService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Scanner;

@SpringBootApplication
public class WeatherDashboardApplication implements CommandLineRunner {

    private final WeatherService weatherService;

    public WeatherDashboardApplication(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public static void main(String[] args) {
        SpringApplication.run(WeatherDashboardApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Chicago");
            System.out.println("2. London");
            System.out.println("3. New York");
            System.out.println("4. Exit");
            System.out.print("Choose a city: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayWeather("Chicago");
                    break;
                case 2:
                    displayWeather("London");
                    break;
                case 3:
                    displayWeather("New York");
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        }
    }

        private void displayWeather (String city){
            Weather weather = weatherService.getCurrentWeather(city);

            System.out.println("City: " + weather.getCity());
            System.out.println("Temperature: " + weather.getTemperature());
            System.out.println("Description: " + weather.getDescription());
            System.out.println("Humidity: " + weather.getHumidity() + "%");

        }
    }

