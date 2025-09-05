package com.shridhar.tmdbapp.service;

import jakarta.annotation.PostConstruct;  // updated import
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class TmdbService {

    @Value("${tmdb.api.key}")
    private String apiKey;

    @Value("${tmdb.base.url}")
    private String baseUrl;

    private WebClient webClient;

    @PostConstruct
    public void init() {
        this.webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

    public Mono<String> searchPerson(String name) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/search/person")
                        .queryParam("api_key", apiKey)
                        .queryParam("query", name)
                        .build())
                .retrieve()
                .bodyToMono(String.class);
    }
}
