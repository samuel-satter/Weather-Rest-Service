package com.example.weatherrestservice.SMHI;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "levelType",
        "level",
        "unit",
        "values"
})

@Data
public class Parameter {

    @JsonProperty("name")
    private String name;

    @JsonProperty("levelType")
    private String levelType;

    @JsonProperty("level")
    private Integer level;

    @JsonProperty("unit")
    private String unit;

    @JsonProperty("values")
    private List<Integer> values;
}
