package com.example.weatherrestservice.entities;

import com.example.weatherrestservice.clients.MetClient;

public class MetEntity extends WeatherEntity {

    MetClient metClient;

    public MetEntity() {
        metClient = new MetClient();
        getInfo();
    }

    private void getInfo() {
        temperature = getTemperature();
        humidity = getHumidity();
    }

}
