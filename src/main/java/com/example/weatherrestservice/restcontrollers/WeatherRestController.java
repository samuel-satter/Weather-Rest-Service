package com.example.weatherrestservice.restcontrollers;


import com.example.weatherrestservice.entities.WeatherEntity;
import com.example.weatherrestservice.service.WeatherInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherRestController {

    private final WeatherInformationService weatherInformationService;

    @Autowired
    public WeatherRestController(WeatherInformationService weatherInformationService) {
        this.weatherInformationService = weatherInformationService;
    }

    @GetMapping("/api/weather/")
    public ResponseEntity<WeatherEntity> getBestWeatherReport() {
        return ResponseEntity.ok().body(weatherInformationService.fetchInformation());
    }


}
