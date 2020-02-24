package com.example.demo.dao;

import com.example.demo.model.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface Ticketdao extends CrudRepository<Ticket, Integer> {
}
