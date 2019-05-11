package com.under.cloudx;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

@Slf4j
@RestController
@RequestMapping("/game")
public class StatefulGameResource {

    private Game game;

    @GetMapping
    public Game currentlyPlaying() {
        return game;
    }

    @EventListener
    public void on(ApplicationReadyEvent event) {
        pickupGame();
    }

    @EventListener
    public void on(SwitchGameEvent event) {
        pickupGame();
    }

    private void pickupGame() {
        List<String> playableGames = asList("Team Fortress", "UnrealTournament", "Final Fantasy");

        int aleatoryItem = new Random().nextInt(playableGames.size());
        game = new Game( playableGames.get(aleatoryItem) );
        log.info("Picked up : {}", game);
    }
}

