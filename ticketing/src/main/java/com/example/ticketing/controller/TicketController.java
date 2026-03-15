package com.example.ticketing.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ticketing.model.ticket;
import com.example.ticketing.service.TicketService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ts;

    public TicketController(TicketService ts) {
        this.ts = ts;
    }

    @GetMapping
    public String getAllTickets() {
        StringBuilder sb = new StringBuilder();
        ArrayList<ticket> tickets = (ArrayList<ticket>) ts.getAllTickets();
        if (tickets.size() == 0) {
            return "No tickets found.";
        }

        for (ticket t: tickets) {
            sb.append("ID: " + t.getId() + ", Title: " + t.getTitle() + ", Description: " + t.getDescription() + ", Status: " + t.getStatus() + ", Priority: " + t.getPriority() + "\n");
        }
        
        return sb.toString();
    }

    @PostMapping
    public String createTicket(@RequestBody ticket newTicket) {
        ts.createTicket(newTicket);
        return "Ticket Created: " + newTicket.getId() + newTicket.getTitle() + newTicket.getDescription() + newTicket.getStatus() + newTicket.getPriority();
    }
    
}
