package com.BMS_Backend.Book_My_Show.Converters;

import com.BMS_Backend.Book_My_Show.Dtos.Request.TheaterRequestDto;
import com.BMS_Backend.Book_My_Show.Models.Theater;

public class TheaterRequestConvertor {
    public static Theater convertDtoToEntity(TheaterRequestDto theaterRequestDto){
        return Theater.builder()
                .name(theaterRequestDto.getName())
                .location(theaterRequestDto.getLocation())
                .build();
    }
}
