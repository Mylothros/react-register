package com.register.RegisterForm.Service;

import com.register.RegisterForm.DataTransferObject.UserDto;

import java.util.List;

public interface UserService {
    String addUser(UserDto userDto);
    List<UserDto> getAllUsers();
}