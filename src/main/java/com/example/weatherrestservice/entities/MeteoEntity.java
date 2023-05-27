package com.example.weatherrestservice.entities;

import com.example.weatherrestservice.clients.MeteoClient;

import java.time.LocalDateTime;

public class MeteoEntity extends WeatherEntity{

    MeteoClient meteoClient;

    public MeteoEntity() {
        meteoClient = new MeteoClient();
        getInfo();
    }

    public MeteoEntity(Double temperature, Integer humidity, LocalDateTime localDateTime, String source) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.localDateTime = localDateTime;
        this.source = source;
    }

    private void getInfo() {
        temperature = getTemperature();
        humidity = getHumidity();
    }

}
