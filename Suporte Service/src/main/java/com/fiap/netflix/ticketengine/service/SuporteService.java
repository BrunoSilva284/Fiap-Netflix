package com.fiap.netflix.ticketengine.service;

import com.fiap.netflix.gateway.suporte.api.SuporteApi;
import com.fiap.netflix.gateway.suporte.api.model.Problema;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;

public class SuporteService implements SuporteApi {

    @Override
    @HystrixCommand(fallbackMethod = "suporteReportarError")
    public ResponseEntity<String> suporteReportarPost(@Valid Problema body) {
        return null;
    }

    private String suporteReportarError(Problema body) {
        return "Sem informações sobre esse item.";
    }
}
