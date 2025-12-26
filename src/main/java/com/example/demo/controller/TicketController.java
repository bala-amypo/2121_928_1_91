package com.example.demo.controller;

import com.example.demo.model.Ticket;
import com.example.demo.service.TicketService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService service;

    public TicketController(TicketService service) {
        this.service = service;
    }

    @PostMapping
    public Ticket create(@RequestBody Ticket t) {
        return service.createTicket(t);
    }

    @GetMapping("/{id}")
    public Ticket get(@PathVariable Long id) {
        return service.getTicket(id);
    }
}
