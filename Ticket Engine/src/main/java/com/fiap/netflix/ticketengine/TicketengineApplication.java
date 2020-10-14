package com.fiap.netflix.ticketengine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@EnableCircuitBreaker
@SpringBootApplication
public class TicketengineApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketengineApplication.class, args);
    }

}
