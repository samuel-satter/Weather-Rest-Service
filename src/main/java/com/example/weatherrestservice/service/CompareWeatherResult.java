package com.example.weatherrestservice.service;

import com.example.weatherrestservice.entities.WeatherEntity;

public class CompareWeatherResult {

    public WeatherEntity compareWeather(WeatherEntity smhiEntity, WeatherEntity metEntity, WeatherEntity meteoEntity) {
        if (metEntity.getTemperature() > meteoEntity.getTemperature() && metEntity.getTemperature() > smhiEntity.getTemperature()) {
            return metEntity;
        } else if (meteoEntity.getTemperature() > smhiEntity.getTemperature()) {
            return meteoEntity;
        } else {
            return smhiEntity;
        }
    }
}
