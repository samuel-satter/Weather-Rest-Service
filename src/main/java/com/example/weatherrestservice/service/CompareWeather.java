package com.example.weatherrestservice.service;


import com.example.weatherrestservice.clients.MetClient;
import com.example.weatherrestservice.clients.SmhiClient;
import com.example.weatherrestservice.entities.SmhiEntity;
import com.example.weatherrestservice.entities.WeatherEntity;
import com.example.weatherrestservice.met.MetWeatherService;
import com.example.weatherrestservice.met.Properties;
import com.example.weatherrestservice.met.Timeseries;
import com.example.weatherrestservice.smhi.Parameter;
import com.example.weatherrestservice.smhi.SmhiWebservice;
import com.example.weatherrestservice.smhi.TimeSeries;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

@Service
@Data
public class CompareWeather {

    private SmhiEntity smhiEntity;

    String bestSource;

    private final SmhiClient smhiClient;


    private final MetClient metClient;

   @Autowired
    public CompareWeather(SmhiClient smhiClient, MetClient metClient) {
        this.smhiClient = smhiClient;
        this.metClient = metClient;
    }


    private LocalDateTime getDateTime(String time) {
        return LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME);
    }

    public WeatherEntity getBestWeatherReport() {
        bestSource = "SMHI";
        SmhiWebservice smhiWebservice = smhiClient.getDataFromSmhi();
        LocalDateTime targetTime = LocalDateTime.now().plusDays(1);


        List<TimeSeries> timeSeriesList = smhiWebservice.getTimeSeries().stream().filter(timeSeries -> getDateTime(timeSeries.getValidTime()).isAfter(targetTime)).toList();
        Optional<Parameter> parameterTemperature = timeSeriesList.get(0).getParameters().stream().filter(parameter -> parameter.getName().equals("t")).findFirst();
        int temperature = 0;
        if (parameterTemperature.isPresent()) {
            temperature = parameterTemperature.get().getValues().get(0);
        }

        Optional<Parameter> parameterHumidity = timeSeriesList.get(0).getParameters().stream().filter(parameter -> parameter.getName().equals("r")).findFirst();
        int humidity = 0;
        if (parameterHumidity.isPresent()) {
            humidity = parameterHumidity.get().getValues().get(0);
        }


        MetWeatherService metWeatherService = metClient.getDataFromMet();
        List<Properties> metTimeseriesList =  metWeatherService
//        ((LinkedHashMap) properties.additionalProperties.get("properties")).get("timeseries")

    return smhiEntity;
    }

}
