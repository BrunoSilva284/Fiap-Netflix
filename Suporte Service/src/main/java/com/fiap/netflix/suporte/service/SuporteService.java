package com.fiap.netflix.suporte.service;

import com.fiap.netflix.gateway.suporte.model.Problema;
import com.fiap.netflix.gateway.suporte.model.TicketConsulta;
import com.fiap.netflix.suporte.model.Ticket;
import com.fiap.netflix.suporte.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SuporteService  {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TicketQueueSender ticketQueueSender;

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    public List<TicketConsulta> consultarChamadosByDesc(String desc){
        List<TicketConsulta> consultas = new ArrayList<>();
        List<Ticket> listaTicket = ticketRepository.consultarByDesc(desc);

        for(Ticket ticket : listaTicket) {
            consultas.add(deParaTicketConsulta(ticket));
        }

        return consultas;
    }

    public String suporteReportarError(Problema body) {
        if(verificarDados(body)) {
            Ticket novoTicket = this.deParaProblema(body);
            return ticketQueueSender.send(novoTicket) ? "OK" : "NOK";
        } else {
            return "ERR-1 Campos obrigatórios não informados.";
        }
    }

    public String salvarTicket(Ticket ticket) {
        if(verificarDadosTicket(ticket)) {
            ticketRepository.save(ticket);
            return "OK";
        } else {
            return "ERR-1 Campos obrigatórios não informados.";
        }
    }

    /**
     * Verifica se os campos obrigatórios foram preenchidos
     * @param param input dos problemas
     * @return booleana se itens ok ou não
     */
    private boolean verificarDados(Problema param) {
        if(param.getDescricaoErro() == null || param.getDescricaoErro().isEmpty()){
            return false;
        }

        return true;
    }

    /**
     * Verifica se os campos obrigatórios foram preenchidos
     * @param param input do ticket
     * @return booleana se itens ok ou não
     */
    private boolean verificarDadosTicket(Ticket param) {
        if(param.getDescricaoErro() == null || param.getDescricaoErro().isEmpty()){
            return false;
        }
        if(param.getDataCriacao() == null) {
            return false;
        }
        if(param.getIdUsuario() == null || param.getIdUsuario() <= 0) {
            return false;
        }

        return true;
    }

    /**
     * Cria novo objeto Ticket com base no input para cadastro
     * @param param input dos problemas
     * @return objeto ticket para persistência
     */
    private Ticket deParaProblema(Problema param){
        Ticket ticket = new Ticket();
        ticket.setIdFilme(param.getIdFilme());
        ticket.setIdUsuario(param.getIdUsuario());
        ticket.setDescricaoErro(param.getDescricaoErro());
        ticket.setDataCriacao(new Date());

        return ticket;
    }

    /**
     * Cria novo objeto TicketConsulta com base no input vindo do banco de dados
     * @param ticket retorno do banco de dados
     * @return objeto ticket consulta para retornar
     */
    private TicketConsulta deParaTicketConsulta(Ticket ticket){
        TicketConsulta ticketConsulta = new TicketConsulta();
        ticketConsulta.setIdTicket(ticket.getId());
        ticketConsulta.setIdFilme(ticket.getIdFilme());
        ticketConsulta.setIdUsuario(ticket.getIdUsuario());
        ticketConsulta.setDescricaoErro(ticket.getDescricaoErro());
        ticketConsulta.setDataCriacao(this.simpleDateFormat.format(ticket.getDataCriacao()));

        if(ticket.getAtendente() != null) {
            ticketConsulta.setIdAtendente(ticket.getAtendente().getId());
        }

        return ticketConsulta;
    }
}
