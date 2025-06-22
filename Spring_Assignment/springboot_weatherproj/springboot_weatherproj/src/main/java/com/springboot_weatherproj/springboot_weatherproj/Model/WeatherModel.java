package com.springboot_weatherproj.springboot_weatherproj.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherModel {

    private LocalDate date;
    private double temperatureMax;
    private double temperatureMin;
    private double precipitation;
    private double windSpeed;

}
