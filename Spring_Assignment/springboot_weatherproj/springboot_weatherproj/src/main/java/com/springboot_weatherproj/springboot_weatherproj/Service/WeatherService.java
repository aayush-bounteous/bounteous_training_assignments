package com.springboot_weatherproj.springboot_weatherproj.Service;


import com.springboot_weatherproj.springboot_weatherproj.Model.WeatherModel;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDate;
import java.util.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class WeatherService {

    private final RestTemplate restTemplate = new RestTemplate();

    // Hardcoded city data (name -> [latitude, longitude])
    private static final Map<String, double[]> cities = Map.ofEntries(
            Map.entry("New York", new double[]{40.7128, -74.0060}),
            Map.entry("London", new double[]{51.5074, -0.1278}),
            Map.entry("Paris", new double[]{48.8566, 2.3522}),
            Map.entry("Tokyo", new double[]{35.6895, 139.6917}),
            Map.entry("Sydney", new double[]{-33.8688, 151.2093}),
            Map.entry("Moscow", new double[]{55.7558, 37.6173}),
            Map.entry("Berlin", new double[]{52.5200, 13.4050}),
            Map.entry("Dubai", new double[]{25.2048, 55.2708}),
            Map.entry("Toronto", new double[]{43.6532, -79.3832}),
            Map.entry("San Francisco", new double[]{37.7749, -122.4194})
    );

    private static final String API_URL_TEMPLATE =
            "https://api.open-meteo.com/v1/forecast?latitude=%f&longitude=%f&daily=temperature_2m_max,temperature_2m_min,precipitation_sum,windspeed_10m_max&timezone=auto";

    public List<WeatherModel> getWeatherForCity(String cityName) {
        if (!cities.containsKey(cityName)) {
            throw new IllegalArgumentException("City not found: " + cityName);
        }

        double[] coords = cities.get(cityName);
        String url = String.format(API_URL_TEMPLATE, coords[0], coords[1]);

        Map<String, Object> response = restTemplate.getForObject(url, Map.class);
        if (response == null || !response.containsKey("daily")) {
            throw new RuntimeException("Failed to fetch weather data");
        }

        Map<String, Object> daily = (Map<String, Object>) response.get("daily");

        List<String> dates = (List<String>) daily.get("time");
        List<Double> tempMax = (List<Double>) daily.get("temperature_2m_max");
        List<Double> tempMin = (List<Double>) daily.get("temperature_2m_min");
        List<Double> precipitation = (List<Double>) daily.get("precipitation_sum");
        List<Double> windspeed = (List<Double>) daily.get("windspeed_10m_max");

        List<WeatherModel> forecast = new ArrayList<>();
        for (int i = 0; i < dates.size(); i++) {
            WeatherModel wm = new WeatherModel(
                    LocalDate.parse(dates.get(i)),
                    tempMax.get(i),
                    tempMin.get(i),
                    precipitation.get(i),
                    windspeed.get(i)
            );
            forecast.add(wm);
        }
        return forecast;
    }

    public Map<String, List<WeatherModel>> compareCities(String city1, String city2) {
        List<WeatherModel> city1Weather = getWeatherForCity(city1);
        List<WeatherModel> city2Weather = getWeatherForCity(city2);

        Map<String, List<WeatherModel>> comparison = new HashMap<>();
        comparison.put(city1, city1Weather);
        comparison.put(city2, city2Weather);

        return comparison;
    }

    public Set<String> getAvailableCities() {
        return cities.keySet();
    }
}

