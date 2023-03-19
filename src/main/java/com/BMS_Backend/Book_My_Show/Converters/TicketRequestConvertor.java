package com.BMS_Backend.Book_My_Show.Converters;

import com.BMS_Backend.Book_My_Show.Dtos.Request.TicketRequestDto;
import com.BMS_Backend.Book_My_Show.Models.Ticket;

public class TicketRequestConvertor {
    public static Ticket convertDtoToEntity(TicketRequestDto ticketRequestDto){
        return new Ticket();
    }
}
