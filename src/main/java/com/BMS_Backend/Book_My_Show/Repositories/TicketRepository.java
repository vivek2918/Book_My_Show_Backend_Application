package com.BMS_Backend.Book_My_Show.Repositories;

import com.BMS_Backend.Book_My_Show.Models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
}
