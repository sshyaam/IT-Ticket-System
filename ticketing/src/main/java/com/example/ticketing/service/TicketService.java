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

    public ticket createTicket(ticket newTicket) {
        newTicket.setId(nextId++);
        tickets.add(newTicket);
        return newTicket;
    }
}
