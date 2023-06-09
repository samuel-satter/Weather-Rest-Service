package com.example.weatherrestservice.controller;

import com.example.weatherrestservice.model.WeatherPrognosis;
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

    @GetMapping("/weather")
    public String getWeatherPage(Model model) {
        WeatherPrognosis weatherPrognosis = weatherInformationService.fetchInformation();
        model.addAttribute("temperature", weatherPrognosis.getTemperature());
        model.addAttribute("humidity", weatherPrognosis.getHumidity());
        model.addAttribute("time", weatherPrognosis.getTime());
        model.addAttribute("source", weatherPrognosis.getSource());
        return "weather.html";
    }

}
