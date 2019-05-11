package com.under.cloudx;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpMethod.GET;

@Slf4j
@Component
public class GamerSessionMonitor {

    private static final String ENDPOINT = "/game";
    private final DiscoveryClient discoveryClient;
    private final RestTemplate restTemplate;
    private final Map<Game, Integer> playedGames;

    @Autowired
    public GamerSessionMonitor(DiscoveryClient discoveryClient,
                               RestTemplate restTemplate) {
        this.discoveryClient = discoveryClient;
        this.restTemplate = restTemplate;
        this.playedGames = new HashMap<>();
    }

    @Scheduled(cron = "*/5 * * * * ?")
    public void findGamerSessions() {
        playedGames.clear();

        List<ServiceInstance> instances = discoveryClient.getInstances("gamer-session");
        for (ServiceInstance instance : instances) {
            URI instanceUri = URI.create( instance.getUri().toString() + ENDPOINT );
            System.out.println(instance.getInstanceId() + " uri = " + instanceUri.toString());

            RequestEntity request = RequestEntity.method(GET, instanceUri)
                    .accept(MediaType.APPLICATION_JSON)
                    .build();

            ResponseEntity<Game> response = restTemplate.exchange(request, Game.class);

            Game game = response.getBody();
            Integer counter = playedGames.getOrDefault(game, 0);
            playedGames.put(game, ++counter);
        }

        log.info("=== Monitor report");
        playedGames.forEach((game, counter) ->
                log.info("{} - {} player(s)", game.getName(), counter)
        );
    }
}

