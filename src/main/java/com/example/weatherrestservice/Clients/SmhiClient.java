package com.example.weatherrestservice.Clients;

import com.example.weatherrestservice.SMHI.SmhiWebservice;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class SmhiClient {
    public WebClient client = WebClient.create();
    public SmhiWebservice smhiWebservice;

    public SmhiClient() {
        smhiWebservice = getDataFromSmhi();
    }


    public SmhiWebservice getDataFromSmhi() {
        Mono<SmhiWebservice> mono = client
                .get()
                .uri("https://opendata-download-metfcst.smhi.se/api/category/pmp3g/version/2/geotype/point/lon/18.0300/lat/59.3110/data.json")
                .retrieve()
                .bodyToMono(SmhiWebservice.class);
        return mono.block();
    }

}
