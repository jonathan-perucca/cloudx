package com.under.cloudx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class StatefulGameResource {

    private final String host;

    @Autowired
    public StatefulGameResource(@Value("${app.host}") String host) {
        this.host = host;
    }

    @GetMapping
    public Game currentlyPlaying() {
        return new Game( "UnrealTournament", host );
    }
}