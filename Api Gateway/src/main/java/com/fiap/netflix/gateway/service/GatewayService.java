package com.fiap.netflix.gateway.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class GatewayService {

    @Autowired
    private DiscoveryClient discoveryClient;

    public String getInstanceUri(String serviceName) {
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);

        if(instances.isEmpty()){
            throw new RuntimeException("No instances of: " + serviceName + " running!");
        } else {
            return instances.get(0).getUri().toString();
        }
    }

    private void createTicket() {
        String uri = getInstanceUri("ticketengine");

        RestTemplate restTemplate = new RestTemplate();
        //uri += "/v1/productservice/product/%s", "123");

            /*
            ResponseEntity<ResponseClass> restExchange = restTemplate.exchange(uri,
                    HttpMethod.GET, null, ResponseClass.class, "parameters");
            ResponseClass response = restExchange.getBody();
             */

    }

}
