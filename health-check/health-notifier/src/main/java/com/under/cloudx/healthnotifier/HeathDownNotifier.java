package com.under.cloudx.healthnotifier;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Slf4j
@Component
public class HeathDownNotifier {

    private final String ENDPOINT = "/actuator/health";
    private final RestTemplate restTemplate;
    private final String appUrl;

    @Autowired
    public HeathDownNotifier(RestTemplate restTemplate,
                             @Value("${app-with-health.url}") String appUrl) {
        this.restTemplate = restTemplate;
        System.out.println("App Url resolved to : " + appUrl);
        this.appUrl = appUrl;
    }

    @Scheduled(cron = "*/2 * * * * ?")
    public void checkHealth() {
        RequestEntity requestEntity = RequestEntity
                .method(HttpMethod.GET, URI.create(appUrl + ENDPOINT))
                .accept(MediaType.APPLICATION_JSON)
                .build();
        try {
            restTemplate.exchange(requestEntity, Void.class);
            log.info("Service is up");
        } catch (RestClientException e) {
            if(e.getMessage() != null && e.getMessage().contains("503")) {
                log.info("Service unavailable");
            } else {
                log.info("Service completely unreachable");
            }
        }
    }

}