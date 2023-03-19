package com.BMS_Backend.Book_My_Show.Controllers;

import com.BMS_Backend.Book_My_Show.Dtos.Request.TheaterRequestDto;
import com.BMS_Backend.Book_My_Show.Services.Impl.TheaterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theater")
public class TheaterController {
    @Autowired
    TheaterServiceImpl theaterService;
    @PostMapping("/add")
    public ResponseEntity<String> addTheater(@RequestBody TheaterRequestDto theaterRequestDto){
        try {
            String response = theaterService.addTheater(theaterRequestDto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
