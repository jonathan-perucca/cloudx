package com.under.cloudx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GamerSessionApp {

    public static void main(String[] args) {
        SpringApplication.run(GamerSessionApp.class, args);
    }

}
