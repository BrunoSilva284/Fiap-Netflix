package com.fiap.netflix.gateway.suporte.api;

import com.fiap.netflix.gateway.service.GatewayService;
import com.fiap.netflix.gateway.suporte.model.Problema;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@RestController
public class SuporteApiController implements SuporteApi {

    @Value("${suporte_criarChamadoUrl}")
    private String suporteCriarChamadoUrl;

    @Autowired
    private GatewayService gatewayService;

    @HystrixCommand(fallbackMethod = "suporteReportarError")
    public ResponseEntity<String> suporteReportarPost(@ApiParam(value = "Informações do problema ocorrido" ,required=true )  @Valid @RequestBody Problema body) {
        String url = gatewayService.getInstanceUri("suporte-service");

        RestTemplate restTemplate = new RestTemplate();
        url += suporteCriarChamadoUrl;

        String restExchange = restTemplate.postForObject(url, body, String.class);

        return new ResponseEntity<String>(restExchange, HttpStatus.OK);
    }

    private ResponseEntity<String> suporteReportarError(Problema body) {
        return new ResponseEntity<String>("Não foi possível registrar sua reclamação, tente novamente mais tarde.", HttpStatus.BAD_REQUEST);
    }
}
