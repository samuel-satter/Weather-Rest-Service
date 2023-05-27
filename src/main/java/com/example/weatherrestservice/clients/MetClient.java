package com.example.weatherrestservice.clients;

import com.example.weatherrestservice.met.MetWeatherService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
@Service
public class MetClient {

    public WebClient client = WebClient.create();

    public MetWeatherService getDataFromMet() {
        Mono<MetWeatherService> mono = client
                .get()
                .uri("https://api.met.no/weatherapi/locationforecast/2.0/compact?lat=59.3110&lon=18.0300")
                .retrieve()
                .bodyToMono(MetWeatherService.class);
        return mono.block();
    }
}
