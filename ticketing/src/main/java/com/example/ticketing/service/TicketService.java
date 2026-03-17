package com.example.ticketing.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ticketing.model.ticket;
import com.example.ticketing.repository.TicketRepository;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public ticket getTicketById(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    public ticket createTicket(ticket newTicket) {
        return ticketRepository.save(newTicket);
    }

    public ticket updateTicketStatus(Long id, String newStatus) {
        ticket t = ticketRepository.findById(id).orElse(null);
        if (t != null) {
            t.setStatus(newStatus);
            return ticketRepository.save(t);
        } else {
            return null;
        }
    }

    public boolean deleteTicketService(Long id) {
        if (!ticketRepository.existsById(id)) {
            return false;
        }
        ticketRepository.deleteById(id);
        return true;
    }
}
