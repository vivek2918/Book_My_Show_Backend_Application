package com.BMS_Backend.Book_My_Show.Dtos.Request;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TicketRequestDto {
    private int showId;
    private List<String> requestedSeats = new ArrayList<>();
    private int userId;
}
