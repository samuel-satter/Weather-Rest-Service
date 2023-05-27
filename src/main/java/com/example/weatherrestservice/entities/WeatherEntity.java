package com.example.weatherrestservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
abstract public class WeatherEntity {
    public Double temperature;
    public Integer humidity;
    public LocalDateTime localDateTime;
    public String source;

}
