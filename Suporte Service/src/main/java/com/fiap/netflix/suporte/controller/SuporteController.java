package com.fiap.netflix.suporte.controller;

import com.fiap.netflix.gateway.suporte.api.SuporteApi;
import com.fiap.netflix.gateway.suporte.model.Problema;
import com.fiap.netflix.suporte.service.SuporteService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class SuporteController implements SuporteApi {

    @Autowired
    private SuporteService suporteService;

    @Override
    @HystrixCommand(fallbackMethod = "suporteReportarError")
    public ResponseEntity<String> suporteReportarPost(@Valid Problema body) {
        return new ResponseEntity<String>("tudo ok", HttpStatus.OK);
    }

    private ResponseEntity<String> suporteReportarError(Problema body) {
        return new ResponseEntity<String>("Sem informações sobre esse item.", HttpStatus.OK);
    }
}