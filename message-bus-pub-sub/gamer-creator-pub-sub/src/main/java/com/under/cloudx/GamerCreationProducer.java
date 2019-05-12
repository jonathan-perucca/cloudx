package com.under.cloudx;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class GamerCreationProducer {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public GamerCreationProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(cron = "*/5 * * * * ?")
    public void createNewGame() {
        var gameCreated = new GameCreated();
        gameCreated.setName(UUID.randomUUID().toString());

        rabbitTemplate.convertAndSend("gamer.fanout", "", gameCreated);
    }
}

