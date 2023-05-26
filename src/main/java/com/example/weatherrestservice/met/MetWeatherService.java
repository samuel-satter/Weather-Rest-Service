package com.example.weatherrestservice.met;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

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
