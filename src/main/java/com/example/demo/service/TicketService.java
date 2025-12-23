package com.example.demo.service;

import com.example.demo.model.Ticket;

public interface TicketService {
    Ticket create(Ticket ticket);
    Ticket get(Long id);
}
