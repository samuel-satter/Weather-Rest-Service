package com.example.weatherrestservice.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Getter
public class WeatherPrognosis {

    private Double temperature;
    private Integer humidity;
    private LocalDateTime time;
    private String source;

    public WeatherPrognosis(Double temperature, Integer humidity, LocalDateTime time, String source) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.time = time;
        this.source = source;
    }

}
