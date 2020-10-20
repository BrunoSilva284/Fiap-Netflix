package com.fiap.netflix.suporte.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TicketConsumer {

    @Autowired
    private SuporteService suporteService;

    Logger logger = LoggerFactory.getLogger(TicketConsumer.class);

    @RabbitListener(queues = {"${queue.suporte.name}"})
    public void receive(Message ticket) {
        try {
            logger.info("Chamado recebido para cadastro: " + ticket);
            //new String(ticket.getBody())
            // suporteService.salvarTicket(ticket);
        } catch (Exception e) {
            logger.error("Erro ao cadastrar: ", e);
            e.printStackTrace();
        }
        logger.info("Chamado recebido: " + ticket);
    }
}
