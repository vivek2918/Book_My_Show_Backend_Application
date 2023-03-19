package com.BMS_Backend.Book_My_Show.Services;

import com.BMS_Backend.Book_My_Show.Dtos.Request.UserRequestDto;
import com.BMS_Backend.Book_My_Show.Models.User;

public interface UserService {
    String addUser(UserRequestDto userRequestDto);
    User getUserById(int userId);
    User getUserByMobileNumber(String MobileNumber);
}
