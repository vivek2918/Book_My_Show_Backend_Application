package com.BMS_Backend.Book_My_Show.Services;

import com.BMS_Backend.Book_My_Show.Dtos.Request.TheaterRequestDto;

public interface TheaterService {
    String addTheater(TheaterRequestDto theaterRequestDto) throws Exception;
}
