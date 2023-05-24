package com.example.weatherrestservice.RestControllers;


import com.example.weatherrestservice.Entities.WeatherEntity;
import com.example.weatherrestservice.Service.CompareWeather;
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

   @GetMapping("/rest/weather/{hour}")
    public ResponseEntity<WeatherEntity> getBestWeatherReport(@PathVariable int hour) {
       return ResponseEntity.ok().body(compareWeather.getBestWeatherReport(hour));
   }

   @PostMapping("time")
   public String userEnteredTime(Model model, @RequestParam int hour) {
       model.addAttribute("selectedWeather", compareWeather.getBestWeatherReport(hour));
       return "todays-weather";
   }



}
