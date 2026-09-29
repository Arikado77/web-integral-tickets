package com.webintegral.tickets.repository;

import com.webintegral.tickets.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findByNameContainingIgnoreCase(String name);
}
