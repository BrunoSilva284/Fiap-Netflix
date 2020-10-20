package com.fiap.netflix.suporte;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class SuporteServiceApplication {

    @Value("${queue.suporte.name}")
    private String suporteQueue;

    public static void main(String[] args) {
        SpringApplication.run(SuporteServiceApplication.class, args);
    }

    @Bean
    public Queue queue() {
        return new Queue(suporteQueue, true);
    }
}
