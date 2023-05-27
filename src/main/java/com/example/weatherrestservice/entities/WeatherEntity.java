package com.example.weatherrestservice.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Getter
public class WeatherEntity {

    public WeatherEntity(Double temperature, Integer humidity, LocalDateTime localDateTime, String source) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.localDateTime = localDateTime;
        this.source = source;
    }
    private Double temperature;
    private Integer humidity;
    private LocalDateTime localDateTime;
    private String source;

}
