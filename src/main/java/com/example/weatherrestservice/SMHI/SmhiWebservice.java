package com.example.weatherrestservice.SMHI;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "approvedTime",
        "referenceTime",
        "geometry",
        "timeSeries"
})

@Data
public class SmhiWebservice {

    @JsonProperty("approvedTime")
    private String approvedTime;

    @JsonProperty("referenceTime")
    private String referenceTime;

    @JsonProperty("geometry")
    private Geometry geometry;

    @JsonProperty("timeSeries")
    private List<TimeSeries> timeSeries;

}
