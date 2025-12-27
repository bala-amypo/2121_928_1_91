// package com.example.demo.service.impl;

// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.model.Ticket;
// import com.example.demo.repository.TicketRepository;
// import com.example.demo.service.TicketService;
// import org.springframework.stereotype.Service;

// @Service
// public class TicketServiceImpl implements TicketService {

//     private final TicketRepository repository;

//     public TicketServiceImpl(TicketRepository repository) {
//         this.repository = repository;
//     }

//     @Override
//     public Ticket createTicket(Ticket ticket) {
//         return repository.save(ticket);
//     }

//     @Override
//     public Ticket getTicket(Long id) {
//         return repository.findById(id)
//                 .orElseThrow(() ->
//                         new ResourceNotFoundException("Ticket not found"));
//     }
// }


package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Ticket;
import com.example.demo.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl {
    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public Ticket getTicket(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found"));
    }

    // This method was missing
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }
}