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
    private final RestTemplate restTemplate;

    @Autowired
    public GamerSessionMonitor(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Scheduled(cron = "*/5 * * * * ?")
    public void findGamerSessions() {
        URI uri = URI.create("http://gamer-session" + ENDPOINT);
        RequestEntity request = RequestEntity.method(GET, uri)
                .accept(MediaType.APPLICATION_JSON)
                .build();

        ResponseEntity<Game> response = restTemplate.exchange(request, Game.class);

        Game game = response.getBody();

        log.info("=== Monitor report");
        log.info("{} game replied by {}", game.getName(), game.getHost());
    }
}

