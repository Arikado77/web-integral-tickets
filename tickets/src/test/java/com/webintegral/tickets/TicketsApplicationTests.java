package com.webintegral.tickets;

import com.webintegral.tickets.model.Ticket;
import com.webintegral.tickets.repository.TicketRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TicketsApplicationTests {

    @Autowired
    private TicketRepository ticketRepository;

    @Test
    void testTicketRepository() {

        Ticket ticket = new Ticket("Error de inicio de sesion");
        Ticket savedTicket = ticketRepository.save(ticket);

        assertNotNull(savedTicket.getId());

        Ticket foundTicket = ticketRepository.findById(savedTicket.getId())
                .orElse(null);

        assertNotNull(foundTicket);
        assertEquals("Error de inicio de sesion", foundTicket.getName());

        List<Ticket> tickets = ticketRepository
                .findByNameContainingIgnoreCase("INICIO");

        assertFalse(tickets.isEmpty());

        ticketRepository.deleteById(savedTicket.getId());

        assertFalse(ticketRepository.existsById(savedTicket.getId()));
    }
}