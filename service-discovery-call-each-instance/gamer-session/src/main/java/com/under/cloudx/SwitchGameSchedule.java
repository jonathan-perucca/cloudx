package com.under.cloudx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SwitchGameSchedule {

    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    public SwitchGameSchedule(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Scheduled(cron = "*/8 * * * * ?")
    public void sendEvent() {
        eventPublisher.publishEvent( new SwitchGameEvent() );
    }

}
