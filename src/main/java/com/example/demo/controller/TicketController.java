package com.example.demo.controller;

import com.example.demo.dao.Ticketdao;
import com.example.demo.model.Ticket;
import com.example.demo.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    //Create entry in DB
    @RequestMapping(value = "/bookTickets",
            produces = "application/json",
            method = RequestMethod.POST
    )
    public ResponseEntity bookTicket(@RequestBody List<Ticket> tickets) {

        String response = ticketService.saveTickets(tickets);
        return new ResponseEntity<>("Tickets booked : " + tickets.size() ,HttpStatus.OK);
    }

    //Retreive data from DB
    @GetMapping("/getTickets")
    public ResponseEntity getTickets() {
        List<Ticket> response = ticketService.getTickets();
        return new ResponseEntity<>( response ,HttpStatus.OK);
    }

    //Delete data from DB
    @GetMapping("/deleteTicket/{id}")
    public ResponseEntity deleteTicket(@PathVariable int id) {
        String response = ticketService.deleteTicket(id);
        return new ResponseEntity<>( response ,HttpStatus.OK);
    }
}
