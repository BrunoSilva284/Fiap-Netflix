package com.fiap.netflix.suporte.service;

import com.fiap.netflix.suporte.model.Ticket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

@Component
public class TicketConsumer {

    @Autowired
    private SuporteService suporteService;

    Logger logger = LoggerFactory.getLogger(TicketConsumer.class);

    @RabbitListener(queues = {"${queue.suporte.name}"})
    public void receive(Message message) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(message.getBody()));
            Ticket ticket = (Ticket) ois.readObject();
            logger.info("Chamado recebido para cadastro: " + ticket.toString());

            suporteService.salvarTicket(ticket);
        } catch (Exception e) {
            logger.error("Erro ao cadastrar: ", e);
            e.printStackTrace();
        }
        logger.info("Chamado cadastrado com sucesso!");
    }
}
