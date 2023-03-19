package com.BMS_Backend.Book_My_Show.Dtos.Request;

import com.BMS_Backend.Book_My_Show.Enums.ShowType;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ShowRequestDto {

    private LocalDate localDate;
    private LocalTime localTime;
    private ShowType showType;
    private int movieId;
    private int theaterId;
    private int classicSeatPrice;
    private int premiumSeatPrice;
}
