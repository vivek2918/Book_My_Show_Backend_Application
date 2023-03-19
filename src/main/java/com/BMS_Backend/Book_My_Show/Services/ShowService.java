package com.BMS_Backend.Book_My_Show.Services;

import com.BMS_Backend.Book_My_Show.Dtos.Request.ShowRequestDto;

public interface ShowService {
    String addShow(ShowRequestDto showRequestDto);
}
