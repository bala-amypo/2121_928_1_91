// package com.example.demo.controller;

// import com.example.demo.model.Ticket;
// import com.example.demo.service.TicketService;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/api/tickets")
// public class TicketController {

//     private final TicketService service;

//     public TicketController(TicketService service) {
//         this.service = service;
//     }

//     @PostMapping
//     public Ticket create(@RequestBody Ticket t) {
//         return service.createTicket(t);
//     }

//     @GetMapping("/{id}")
//     public Ticket get(@PathVariable Long id) {
//         return service.getTicket(id);
//     }
// }


package com.example.demo.controller;

import com.example.demo.model.Ticket;
import com.example.demo.service.impl.TicketServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@Tag(name = "Tickets")
public class TicketController {
    private final TicketServiceImpl ticketService;

    public TicketController(TicketServiceImpl ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        return ResponseEntity.ok(ticketService.createTicket(ticket));
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets() {
        return ResponseEntity.ok(ticketService.getAllTickets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicket(@PathVariable Long id) {
        return ResponseEntity.ok(ticketService.getTicket(id));
    }
}