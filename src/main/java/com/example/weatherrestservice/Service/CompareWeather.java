package com.example.weatherrestservice.Service;


import com.example.weatherrestservice.Entities.SmhiEntity;
import com.example.weatherrestservice.Entities.WeatherEntity;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class CompareWeather {

    SmhiEntity smhiEntity;

    String bestSource;

    public WeatherEntity getBestWeatherReport(int hour) {
        bestSource = "SMHI";
        return smhiEntity;
    }

}
