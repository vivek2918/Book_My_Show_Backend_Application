package com.BMS_Backend.Book_My_Show.Services.Impl;

import com.BMS_Backend.Book_My_Show.Converters.MovieRequestConvertor;
import com.BMS_Backend.Book_My_Show.Dtos.Request.MovieRequestDto;
import com.BMS_Backend.Book_My_Show.Models.Movie;
import com.BMS_Backend.Book_My_Show.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl {
    @Autowired
    MovieRepository movieRepository;
    public String addMovie(MovieRequestDto movieRequestDto){
        Movie movie = MovieRequestConvertor.convertDtoTOEntity(movieRequestDto);
        movieRepository.save(movie);

        return "movie added successfully";
    }
}
