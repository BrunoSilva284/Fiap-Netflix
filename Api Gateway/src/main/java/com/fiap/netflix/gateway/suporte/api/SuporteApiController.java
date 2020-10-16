package com.fiap.netflix.gateway.suporte.api;

import com.fiap.netflix.gateway.service.GatewayService;
import com.fiap.netflix.gateway.suporte.api.model.Problema;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

public class SuporteApiController implements SuporteApi {

    public ResponseEntity<String> suporteReportarPost(@ApiParam(value = "Informações do problema ocorrido" ,required=true )  @Valid @RequestBody Problema body) {
        String uri = GatewayService.getInstanceUri("suporte-service");

        RestTemplate restTemplate = new RestTemplate();
        //uri += "/v1/productservice/product/%s", "123");

            /*
            ResponseEntity<ResponseClass> restExchange = restTemplate.exchange(uri,
                    HttpMethod.GET, null, ResponseClass.class, "parameters");
            ResponseClass response = restExchange.getBody();
             */
        return new ResponseEntity<String>("OK", HttpStatus.OK);
    }
}
