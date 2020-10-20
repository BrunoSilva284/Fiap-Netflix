package com.fiap.netflix.suporte.repository;

import com.fiap.netflix.suporte.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query("SELECT t FROM Ticket t WHERE t.descricaoErro LIKE %:desc%")
    List<Ticket> consultarByDesc(@Param("desc") String descricao);
}
