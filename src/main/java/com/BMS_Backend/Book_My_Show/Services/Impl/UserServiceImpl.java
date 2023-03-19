package com.BMS_Backend.Book_My_Show.Services.Impl;

import com.BMS_Backend.Book_My_Show.Converters.UserRequestConvertor;
import com.BMS_Backend.Book_My_Show.Dtos.Request.UserRequestDto;
import com.BMS_Backend.Book_My_Show.Models.User;
import com.BMS_Backend.Book_My_Show.Repositories.UserRepository;
import com.BMS_Backend.Book_My_Show.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    public String addUser(UserRequestDto userRequestDto){
//        if(userRequestDto.getName() == null || userRequestDto.getAge() == 0 || userRequestDto.getAddress() == null || userRequestDto.getEmail() == null || userRequestDto.getMobNo() == null){
//            throw new Exception();
//        }
        User user = UserRequestConvertor.convertDtoTOEntity(userRequestDto);

        userRepository.save(user);

        return "user added successfully";
    }

    @Override
    public User getUserById(int userId) {
        return null;
    }

    @Override
    public User getUserByMobileNumber(String MobileNumber) {
        return null;
    }
}
