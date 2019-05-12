package com.under.cloudx;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class GamerEmailerApp {

    public static void main(String[] args) {
        SpringApplication.run(GamerEmailerApp.class, args);
    }

}
