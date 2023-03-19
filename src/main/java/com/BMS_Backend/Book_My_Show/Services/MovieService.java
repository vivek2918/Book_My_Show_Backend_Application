package com.BMS_Backend.Book_My_Show.Services;

import com.BMS_Backend.Book_My_Show.Dtos.Request.MovieRequestDto;

public interface MovieService {
    String addMovie(MovieRequestDto movieRequestDto);
}
