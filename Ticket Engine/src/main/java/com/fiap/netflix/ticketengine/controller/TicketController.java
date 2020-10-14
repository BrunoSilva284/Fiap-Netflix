package com.fiap.netflix.ticketengine.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/ticket")
public class TicketController {

    @HystrixCommand(fallbackMethod = "getStatusError")
    @RequestMapping(value = "/status/{id}", method = RequestMethod.GET)
    public String getStatus(@PathVariable("id") long id) {
        if(id < 0){
            throw new RuntimeException("Valor negativo");
        }
        return "O ticket ID: " + id + " está EM ANDAMENTO.";
    }

    private String getStatusError(long id) {
        return "Sem informações sobre esse item.";
    }

}
