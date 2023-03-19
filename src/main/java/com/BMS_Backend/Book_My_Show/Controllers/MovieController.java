package com.BMS_Backend.Book_My_Show.Controllers;

import com.BMS_Backend.Book_My_Show.Dtos.Request.MovieRequestDto;
import com.BMS_Backend.Book_My_Show.Services.Impl.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    MovieServiceImpl movieService;
    @PostMapping("/add")
    public ResponseEntity<String> addMovie(@RequestBody MovieRequestDto movieRequestDto){
        try {
            String result = movieService.addMovie(movieRequestDto);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
        catch (Exception e){
            String result = "movie could not be added";
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }
}
