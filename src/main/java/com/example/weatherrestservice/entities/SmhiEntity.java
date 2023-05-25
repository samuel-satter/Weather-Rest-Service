package com.example.weatherrestservice.entities;

import com.example.weatherrestservice.clients.SmhiClient;
import org.springframework.stereotype.Component;

import com.example.weatherrestservice.smhi.Parameter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class SmhiEntity extends WeatherEntity {

    SmhiClient smhiClient;

//    public void SmhiClient() {
//        smhiClient = new SmhiClient();
//        temperature = getTemperatureByTime(hour);
//        humidity = getHumidityByTime(hour);
//        localDateTime = getTimeBySmhi(hour);
//        source = "SMHI";
//    }

//    public LocalDateTime getTimeBySmhi(int hour) {
//        return LocalDateTime.parse(smhiClient.smhiWebservice.getTimeSeries().get(hour+1).getValidTime(), DateTimeFormatter.ISO_DATE_TIME);
//    }
//
//    public Integer getTemperatureByTime(int hour) {
//        int temperature = 0;
//        for (Parameter p : smhiClient.smhiWebservice.getTimeSeries().get(hour+1).getParameters()){
//            if (p.getName().equals("t")) {
//                temperature = p.getValues().get(0);
//            }
//        }
//        return temperature;
//    }
//
//    public Integer getHumidityByTime(int hour) {
//        int humidity = 0;
//        for (Parameter p : smhiClient.smhiWebservice.getTimeSeries().get(hour+1).getParameters()) {
//            if (p.getName().equals("r")) {
//                humidity = p.getValues().get(0);
//            }
//        }
//        return humidity;
//    }

}
