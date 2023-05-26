package com.example.weatherrestservice.entities;

import com.example.weatherrestservice.clients.SmhiClient;
import org.springframework.stereotype.Component;

import com.example.weatherrestservice.smhi.Parameter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class SmhiEntity extends WeatherEntity {

    SmhiClient smhiClient;

    public SmhiEntity() {
        smhiClient = new SmhiClient();
        getInfo();
    }

    public void getInfo() {
        temperature = getTemperature();
        humidity = getHumidity();
    }
}
