package com.example.ticketing.controller;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.ticketing.model.ticket;
import com.example.ticketing.service.TicketService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ts;

    public TicketController(TicketService ts) {
        this.ts = ts;
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getTicketById(@PathVariable Long id) {
        ticket t = ts.getTicketById(id);
        if (t == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("ID: " + t.getId() + ", Title: " + t.getTitle() + ", Description: " + t.getDescription() + ", Status: " + t.getStatus() + ", Priority: " + t.getPriority());
    }

    @GetMapping
    public ResponseEntity<String> getAllTickets() {
        StringBuilder sb = new StringBuilder();
        ArrayList<ticket> tickets = (ArrayList<ticket>) ts.getAllTickets();
        if (tickets.size() == 0) {
            return ResponseEntity.notFound().build();
        }

        for (ticket t: tickets) {
            sb.append("ID: " + t.getId() + ", Title: " + t.getTitle() + ", Description: " + t.getDescription() + ", Status: " + t.getStatus() + ", Priority: " + t.getPriority() + "\n");
        }
        
        return ResponseEntity.ok(sb.toString());
    }

    @PostMapping
    public ResponseEntity<String> createTicket(@RequestBody ticket newTicket) {
        ts.createTicket(newTicket);
        return ResponseEntity.ok("Ticket Created: \nID: " + newTicket.getId() + ", Title: " + newTicket.getTitle() + ", Description: " + newTicket.getDescription() + ", Status: " + newTicket.getStatus() + ", Priority: " + newTicket.getPriority());
    }

    @PutMapping("/{id}/status?value={value}")
    public ResponseEntity<String> updateStatusTicket(@PathVariable Long id, @RequestParam String value) {
        
        ticket updatedTicket = ts.updateTicketStatus(id, value);
        if (updatedTicket == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Ticket Updated: \nID: " + updatedTicket.getId() + ", Title: " + updatedTicket.getTitle() + ", Description: " + updatedTicket.getDescription() + ", Status: " + updatedTicket.getStatus() + ", Priority: " + updatedTicket.getPriority());
    }
    
}
