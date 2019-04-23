package com.under.cloudx;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import static org.springframework.boot.actuate.health.Health.down;
import static org.springframework.boot.actuate.health.Health.up;

@Component
public class AleatoryHealthIndicator implements HealthIndicator {

    private Integer counter = 0;

    @Override
    public Health health() {
        return ++counter % 5 > 0
                ? up().build()
                : down().withDetail("reason", "counter % 5").build();
    }
}
