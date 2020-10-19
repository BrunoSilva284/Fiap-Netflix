package com.fiap.netflix.suporte.repository;

import com.fiap.netflix.suporte.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
