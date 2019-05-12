package com.under.cloudx;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Logger {

    @RabbitListener(queues = "gamer.logevent.queue")
    public void sendEmail(GameCreated gameCreated) {
        log.info("would store new game received {}, store now", gameCreated.getName());
    }
}