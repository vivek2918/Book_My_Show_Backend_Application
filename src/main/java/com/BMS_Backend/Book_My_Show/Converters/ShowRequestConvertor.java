package com.BMS_Backend.Book_My_Show.Converters;

import com.BMS_Backend.Book_My_Show.Dtos.Request.ShowRequestDto;
import com.BMS_Backend.Book_My_Show.Models.Show;

public class ShowRequestConvertor {
    public static Show convertDtoToEntity(ShowRequestDto showRequestDto){
        return Show.builder()
                .showDate(showRequestDto.getLocalDate())
                .showTime(showRequestDto.getLocalTime())
                .showType(showRequestDto.getShowType())
                .build();
    }
}
