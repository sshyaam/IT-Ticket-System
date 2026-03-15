package com.example.ticketing.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ticketing.model.ticket;

@Service
public class TicketService {
    private final List<ticket> tickets = new ArrayList<>();
    private long nextId = 1;

    public List<ticket> getAllTickets() {
        return tickets;
    }

    public ticket getTicketById(Long id) {
        for (ticket t: tickets) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        return null;
    }

    public ticket createTicket(ticket newTicket) {
        newTicket.setId(nextId++);
        tickets.add(newTicket);
        return newTicket;
    }

    public ticket updateTicketStatus(Long id, String newStatus) {
        for (ticket t: tickets) {
            System.out.println(t.getId() + " " + id);
            if (t.getId() == id) {
                t.setStatus(newStatus);
                return t;
            }
        }
        return null;
    }
}
