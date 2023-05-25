package com.example.weatherrestservice.smhi;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "type",
        "coordinates"
})

@Data
public class Geometry {
    @JsonProperty("type")
    private String type;

    @JsonProperty("coordinates")
    private List<List<Double>> coordinates;

}
