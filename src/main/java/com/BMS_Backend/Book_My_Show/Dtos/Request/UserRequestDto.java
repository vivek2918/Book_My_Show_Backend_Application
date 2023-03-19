package com.BMS_Backend.Book_My_Show.Dtos.Request;

import lombok.Data;

@Data
public class UserRequestDto {
    private String name;
    private int age;
    private String email;
    private String mobNo;
    private String address;
}
