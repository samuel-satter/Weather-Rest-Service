package com.example.weatherrestservice.service;

import com.example.weatherrestservice.entities.WeatherEntity;
import org.springframework.stereotype.Service;

@Service
public class CompareWeatherResult {

    WeatherInformationService weatherInformationService;


    public WeatherEntity compareWeather() {
        weatherInformationService.addTargetTime();
        if (weatherInformationService.getMetEntity().temperature > weatherInformationService.getMeteoEntity().temperature &&
                weatherInformationService.getMetEntity().temperature > weatherInformationService.getSmhiEntity().temperature) {
            return weatherInformationService.getMetEntity();
        } else if (weatherInformationService.getMeteoEntity().temperature > weatherInformationService.getSmhiEntity().temperature) {
            return weatherInformationService.getMeteoEntity();
        } else {
            return weatherInformationService.getSmhiEntity();
        }
    }
}
