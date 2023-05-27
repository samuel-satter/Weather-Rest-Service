package com.example.weatherrestservice.client;

import com.example.weatherrestservice.meteo.Meteo;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class MeteoClient {

    WebClient client = WebClient.create();

    public Meteo getDataFromMeteo() {
        Mono<Meteo> mono = client
                .get()
                .uri("https://api.open-meteo.com/v1/forecast?latitude=59.30&longitude=18.02&hourly=temperature_2m,relativehumidity_2m")
                .retrieve()
                .bodyToMono(Meteo.class);
        return mono.block();
    }
}
