package com.springboot_weatherproj.springboot_weatherproj.Controller;


import com.springboot_weatherproj.springboot_weatherproj.Model.WeatherModel;

import com.springboot_weatherproj.springboot_weatherproj.Service.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    // Get list of available cities
    @GetMapping("/cities")
    public ResponseEntity<Set<String>> getCities() {
        return ResponseEntity.ok(weatherService.getAvailableCities());
    }

    // Get 7-day forecast for a city
    @GetMapping("/forecast/{city}")
    public ResponseEntity<?> getForecast(@PathVariable String city) {
        try {
            List<WeatherModel> forecast = weatherService.getWeatherForCity(city);
            return ResponseEntity.ok(forecast);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to fetch weather data");
        }
    }

    // Compare weather between two cities
    @GetMapping("/compare")
    public ResponseEntity<?> compareCities(@RequestParam String city1, @RequestParam String city2) {
        try {
            Map<String, List<WeatherModel>> comparison = weatherService.compareCities(city1, city2);
            return ResponseEntity.ok(comparison);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to compare weather data");
        }
    }
}


