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
        String retorno = suporteService.suporteReportarError(body);

        if(retorno.equalsIgnoreCase("OK")) {
            return new ResponseEntity<>("OK", HttpStatus.OK);
        } else if (retorno.contains("ERR-1")){
            return new ResponseEntity<>(retorno, HttpStatus.BAD_REQUEST);
        } else {
            throw new RuntimeException("Ocorreu um erro ao tentar cadastrar o problema.");
        }
    }

    /**
     * Método para fallback
     * @param body
     * @return
     */
    private ResponseEntity<String> suporteReportarError(Problema body) {
        return new ResponseEntity<>("Ocorreu um erro ao tentar cadastrar o problema.", HttpStatus.BAD_REQUEST);
    }
}