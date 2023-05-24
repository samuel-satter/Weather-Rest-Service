package com.example.weatherrestservice.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
abstract public class WeatherEntity {
    public Integer temperature;
    public Integer humidity;
    public LocalDateTime localDateTime;
    public String source;

    @JsonIgnore
    int hour;

}
