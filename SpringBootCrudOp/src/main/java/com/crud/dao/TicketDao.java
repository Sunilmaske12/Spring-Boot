package com.crud.dao;

import org.springframework.data.repository.CrudRepository;

import com.crud.model.Ticket;

public interface TicketDao extends CrudRepository<Ticket, Integer> {

}
