package com.example.weatherrestservice.service;


import com.example.weatherrestservice.clients.MetClient;
import com.example.weatherrestservice.clients.MeteoClient;
import com.example.weatherrestservice.clients.SmhiClient;
import com.example.weatherrestservice.entities.MetEntity;
import com.example.weatherrestservice.entities.MeteoEntity;
import com.example.weatherrestservice.entities.SmhiEntity;
import com.example.weatherrestservice.entities.WeatherEntity;
import com.example.weatherrestservice.met.MetWeatherService;
import com.example.weatherrestservice.met.Timeseries;
import com.example.weatherrestservice.meteo.Hourly;
import com.example.weatherrestservice.meteo.HourlyUnits;
import com.example.weatherrestservice.meteo.Meteo;
import com.example.weatherrestservice.smhi.Parameter;
import com.example.weatherrestservice.smhi.SmhiWebservice;
import com.example.weatherrestservice.smhi.TimeSeries;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Data
public class CompareWeather {

    private SmhiEntity smhiEntity;

    private MetEntity metEntity;

    private MeteoEntity meteoEntity;

    private final MeteoClient meteoClient;

    private final SmhiClient smhiClient;

    private final MetClient metClient;

    String bestSource;

   @Autowired
    public CompareWeather(SmhiClient smhiClient, MetClient metClient, MeteoClient meteoClient) {
        this.smhiClient = smhiClient;
        this.metClient = metClient;
        this.meteoClient = meteoClient;
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
        int smhiTemperature = 0;
        if (parameterTemperature.isPresent()) {
            smhiTemperature = parameterTemperature.get().getValues().get(0);
        }

        Optional<Parameter> parameterHumidity = timeSeriesList.get(0).getParameters().stream().filter(parameter -> parameter.getName().equals("r")).findFirst();
        int smhiHumidity = 0;
        if (parameterHumidity.isPresent()) {
            smhiHumidity = parameterHumidity.get().getValues().get(0);
        }


        MetWeatherService metWeatherService = metClient.getDataFromMet();
        List<Timeseries> timeseriesList = metWeatherService.getProperties().getTimeseries().stream().filter(timeseries -> getDateTime(timeseries.getTime()).isAfter(targetTime)).toList();
        Double metTemperature = timeseriesList.get(0).getData().getInstant().getDetails().getAirTemperature();
        Double metHumidity = timeseriesList.get(0).getData().getInstant().getDetails().getRelativeHumidity();

        List<LocalDateTime> meteoDateTimes = new ArrayList<>();
        Meteo meteo = meteoClient.getDataFromMeteo();
        for (String stringOfDateTime : meteo.getHourly().getTime()) {
            meteoDateTimes.add(getDateTime(stringOfDateTime));
        }
        int index = 1;
        while (meteoDateTimes.stream().iterator().next().isBefore(targetTime)) {
            index++;
        }
//        List<LocalDateTime> hourlyList =  meteoDateTimes.stream().filter(localDateTime -> localDateTime.isAfter(targetTime)).toList();
        Double meteoTemperature = meteo.getHourly().getTemperature2m().get(index);
        Integer meteoHumidity = meteo.getHourly().getRelativehumidity2m().get(index);

        if (smhiTemperature > metTemperature) {
            bestSource = "SMHI";
            return smhiEntity;
        } else {
            bestSource = "MET";
            return metEntity;
        }

    }

}
