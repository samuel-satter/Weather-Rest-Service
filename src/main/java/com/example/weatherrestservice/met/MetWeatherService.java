package com.example.weatherrestservice.met;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.List;

@JsonPropertyOrder({
        "geometry",
        "properties"
})
@Data
public class MetWeatherService {

    @JsonProperty("geometry")
    Geometry geometry;

    @JsonProperty("properties")
    Properties properties;


}
