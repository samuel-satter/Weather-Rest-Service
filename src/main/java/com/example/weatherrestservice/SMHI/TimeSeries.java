package com.example.weatherrestservice.SMHI;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "validTime",
        "parameters"
})

@Data
public class TimeSeries {

    @JsonProperty("validTime")
    private String validTime;

    @JsonProperty("parameters")
    private List<Parameter> parameters;

}


