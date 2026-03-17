package com.example.ticketing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ticketing.model.ticket;

public interface TicketRepository extends JpaRepository<ticket, Long> {
}
