package com.fiap.netflix.gateway.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

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
}
