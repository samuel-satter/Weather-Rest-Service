package com.example.weatherrestservice.meteo;

import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "time",
        "temperature_2m",
        "relativehumidity_2m"
})

public class HourlyUnits {

    @JsonProperty("time")
    private String time;
    @JsonProperty("temperature_2m")
    private String temperature2m;
    @JsonProperty("relativehumidity_2m")
    private String relativehumidity2m;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<>();

    @JsonProperty("time")
    public String getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(String time) {
        this.time = time;
    }

    @JsonProperty("temperature_2m")
    public String getTemperature2m() {
        return temperature2m;
    }

    @JsonProperty("temperature_2m")
    public void setTemperature2m(String temperature2m) {
        this.temperature2m = temperature2m;
    }

    @JsonProperty("relativehumidity_2m")
    public String getRelativehumidity2m() {
        return relativehumidity2m;
    }

    @JsonProperty("relativehumidity_2m")
    public void setRelativehumidity2m(String relativehumidity2m) {
        this.relativehumidity2m = relativehumidity2m;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}