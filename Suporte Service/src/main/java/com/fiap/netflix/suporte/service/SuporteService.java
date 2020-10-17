package com.fiap.netflix.suporte.service;

import com.fiap.netflix.gateway.suporte.model.Problema;
import org.springframework.stereotype.Service;

@Service
public class SuporteService  {


    private String suporteReportarError(Problema body) {
        return "Sem informações sobre esse item.";
    }
}
