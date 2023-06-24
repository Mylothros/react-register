package com.register.RegisterForm.Service.implementation;

import com.register.RegisterForm.DataTransferObject.UserDto;
import com.register.RegisterForm.Entity.User;
import com.register.RegisterForm.Repository.UserRepo;
import com.register.RegisterForm.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserImplementation implements UserService {

    @Autowired
    private UserRepo userRepository;
    @Override
    public String addUser(UserDto userDto) {

        User user = new User(
                userDto.getUserId(),
                userDto.getUserName(),
                userDto.getSurName(),
                userDto.getAddress(),
                userDto.getPhoneNumber()
        );
        userRepository.save(user);
        return user.getUserName();
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : users) {
            UserDto userDto = new UserDto();
            userDto.setUserId(user.getUserId());
            userDto.setUserName(user.getUserName());
            userDto.setSurName(user.getSurName());
            userDto.setAddress(user.getAddress());
            userDto.setPhoneNumber(user.getPhoneNumber());
            userDtoList.add(userDto);
        }
        return userDtoList;
    }
}
