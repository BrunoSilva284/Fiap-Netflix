package com.fiap.netflix.servicediscover;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ServicediscoverApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicediscoverApplication.class, args);
    }

}
