package com.fiap.netflix.suporte.service;

import com.fiap.netflix.gateway.suporte.model.Problema;
import com.fiap.netflix.suporte.model.Ticket;
import com.fiap.netflix.suporte.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SuporteService  {

    @Autowired
    private TicketRepository ticketRepository;

    public String suporteReportarError(Problema body) {
        if(verificarDados(body)) {
            Ticket novoTicket = this.deParaProblema(body);
            ticketRepository.save(novoTicket);
            return "OK";
        } else {
            return "ERR-1 Campos obrigatórios não informados.";
        }
    }

    /**
     * Verifica se os campos obrigatórios foram preenchidos
     * @param param
     * @return
     */
    private boolean verificarDados(Problema param) {
        if(param.getDescricaoErro() == null || param.getDescricaoErro().isEmpty()){
            return false;
        }

        return true;
    }

    /**
     * Cria novo objeto Ticket com base no input para cadastro
     * @param param
     * @return
     */
    private Ticket deParaProblema(Problema param){
        Ticket ticket = new Ticket();
        ticket.setIdFilme(param.getIdFilme());
        ticket.setIdUsuario(param.getIdUsuario());
        ticket.setDescricaoErro(param.getDescricaoErro());
        ticket.setDataCriacao(new Date());

        return ticket;
    }
}
