package com.example.weatherrestservice;

import com.example.weatherrestservice.SMHI.SmhiWebservice;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Configuration
public class Runnable implements CommandLineRunner {

    WebClient client = WebClient.create();

    public SmhiWebservice getSmhiInfo() {
        Mono<SmhiWebservice> mono = client
                .get()
                .uri("https://opendata-download-metfcst.smhi.se/api/category/pmp3g/version/2/geotype/point/lon/18.0300/lat/59.3110/data.json")
                .retrieve()
                .bodyToMono(SmhiWebservice.class);
        return mono.block();
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
