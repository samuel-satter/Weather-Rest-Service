package com.example.weatherrestservice.restcontrollers;


import com.example.weatherrestservice.entities.WeatherEntity;
import com.example.weatherrestservice.service.CompareWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class WeatherRestController {


   private final CompareWeather compareWeather;

   @Autowired
   public WeatherRestController(CompareWeather compareWeather) {
       this.compareWeather = compareWeather;
   }

   @GetMapping("/rest/weather/")
    public ResponseEntity<WeatherEntity> getBestWeatherReport() {
       return ResponseEntity.ok().body(compareWeather.getBestWeatherReport());
   }

   @PostMapping("time")
   public String userEnteredTime(Model model) {
       model.addAttribute("selectedWeather", compareWeather.getBestWeatherReport());
       return "todays-weather";
   }



}
