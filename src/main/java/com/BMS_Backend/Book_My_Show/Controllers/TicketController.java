package com.BMS_Backend.Book_My_Show.Controllers;

import com.BMS_Backend.Book_My_Show.Dtos.Request.TicketRequestDto;
import com.BMS_Backend.Book_My_Show.Services.Impl.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    TicketServiceImpl ticketService;

    @PostMapping("/book")
    public ResponseEntity<String> bookTicket(@RequestBody TicketRequestDto ticketRequestDto){
        try {
            String response = ticketService.addTicket(ticketRequestDto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
