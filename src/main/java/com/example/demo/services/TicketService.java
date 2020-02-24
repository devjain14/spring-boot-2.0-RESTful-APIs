package com.example.demo.services;

import com.example.demo.dao.Ticketdao;
import com.example.demo.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    private Ticketdao dao;

    public String saveTickets(@RequestBody List<Ticket> tickets) {

        dao.saveAll(tickets);
        return "ticket booked : " + tickets.size();
    }

    public List<Ticket> getTickets() {
        return (List<Ticket>) dao.findAll();
    }

    public String deleteTicket(int id) {
        Optional<Ticket> ticket = dao.findById(id);
        if(ticket.isPresent()){
            dao.delete(ticket.get());
            return "ticket deleted successfully";
        }
        return "ticket not found with provided Id";
    }
}

