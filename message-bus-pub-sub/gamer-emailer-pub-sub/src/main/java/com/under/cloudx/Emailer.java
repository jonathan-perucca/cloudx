package com.under.cloudx;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Emailer {

    @RabbitListener(queues = "gamer.emailer.queue")
    public void sendEmail(GameCreated gameCreated) {
        log.info("game {} just received, send mail now", gameCreated.getName());
    }
}