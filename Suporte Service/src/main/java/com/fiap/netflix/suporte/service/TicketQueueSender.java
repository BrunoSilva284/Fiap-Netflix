package com.fiap.netflix.suporte.service;

import com.fiap.netflix.suporte.model.Ticket;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TicketQueueSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    public boolean send(Ticket ticket) {
        try {
            rabbitTemplate.convertAndSend(this.queue.getName(), ticket.getDescricaoErro());
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
