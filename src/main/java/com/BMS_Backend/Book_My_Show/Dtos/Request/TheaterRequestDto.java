package com.BMS_Backend.Book_My_Show.Dtos.Request;

import lombok.Data;

@Data
public class TheaterRequestDto {
    private String name;
    private String location;
    private  int classicSeatsCount;
    private int premiumSeatsCount;

}
