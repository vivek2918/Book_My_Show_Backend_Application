package com.BMS_Backend.Book_My_Show.Services;

import com.BMS_Backend.Book_My_Show.Dtos.Request.TicketRequestDto;

public interface TicketService {
    String addTicket(TicketRequestDto ticketRequestDto) throws Exception;
}
