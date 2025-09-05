package com.shridhar.tmdbapp.controller;

import com.shridhar.tmdbapp.service.TmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class TmdbController {

    @Autowired
    private TmdbService tmdbService;

    @GetMapping("/search/person")
    public Mono<String> searchPerson(@RequestParam String name) {
        return tmdbService.searchPerson(name);
    }
}
