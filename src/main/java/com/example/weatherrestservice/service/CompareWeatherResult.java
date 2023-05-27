package com.example.weatherrestservice.service;

import com.example.weatherrestservice.model.WeatherPrognosis;

public class CompareWeatherResult {

    public WeatherPrognosis compareWeather(WeatherPrognosis smhiEntity, WeatherPrognosis metEntity, WeatherPrognosis meteoEntity) {
        if (metEntity.getTemperature() > meteoEntity.getTemperature() && metEntity.getTemperature() > smhiEntity.getTemperature()) {
            return metEntity;
        } else if (meteoEntity.getTemperature() > smhiEntity.getTemperature()) {
            return meteoEntity;
        } else {
            return smhiEntity;
        }
    }
}
