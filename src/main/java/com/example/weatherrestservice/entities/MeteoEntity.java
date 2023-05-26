package com.example.weatherrestservice.entities;

import com.example.weatherrestservice.clients.MeteoClient;

public class MeteoEntity extends WeatherEntity{

    MeteoClient meteoClient;

    public MeteoEntity() {
        meteoClient = new MeteoClient();
        getInfo();
    }

    private void getInfo() {
        temperature = getTemperature();
        humidity = getHumidity();
    }

}
