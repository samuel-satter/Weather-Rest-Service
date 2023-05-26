package com.example.weatherrestservice.controllers;

import com.example.weatherrestservice.service.CompareWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeatherController {

    private final CompareWeather compareWeather;

    @Autowired
    public WeatherController(CompareWeather compareWeather) {
        this.compareWeather = compareWeather;
    }

    @GetMapping("weather")
    public String getWeatherPage(Model model) {
        model.addAttribute(compareWeather.getBestWeatherReport());
        model.addAttribute(compareWeather.getBestSource());
        return "weather.html";
    }

}
