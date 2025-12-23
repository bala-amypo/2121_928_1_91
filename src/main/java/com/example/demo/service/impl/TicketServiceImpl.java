package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Ticket;
import com.example.demo.repository.TicketRepository;
import com.example.demo.service.TicketService;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository repo;

    public TicketServiceImpl(TicketRepository repo) {
        this.repo = repo;
    }

    public Ticket create(Ticket ticket) {
        if (ticket.getDescription().length() < 10)
            throw new BadRequestException("Description too short");
        return repo.save(ticket);
    }

    public Ticket get(Long id) {
        return repo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Ticket not found"));
    }
}
