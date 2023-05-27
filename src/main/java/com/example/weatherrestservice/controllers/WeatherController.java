package com.example.weatherrestservice.controllers;

import com.example.weatherrestservice.service.WeatherInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeatherController {

    private final WeatherInformationService weatherInformationService;

    @Autowired
    public WeatherController(WeatherInformationService weatherInformationService) {
        this.weatherInformationService = weatherInformationService;
    }

    @GetMapping("weather")
    public String getWeatherPage(Model model) {
        model.addAttribute(weatherInformationService.addTargetTime());
        model.addAttribute(weatherInformationService.getBestSource());
        return "weather.html";
    }

}
