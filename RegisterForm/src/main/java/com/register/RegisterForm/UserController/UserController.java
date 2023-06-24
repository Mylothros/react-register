package com.register.RegisterForm.UserController;

import com.register.RegisterForm.DataTransferObject.UserDto;
import com.register.RegisterForm.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Add the origin for CORS
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/save")
    public String saveUser(@RequestBody UserDto userDto) {
        String id = userService.addUser(userDto);
        return id;
    }

    @GetMapping(path = "/get")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }
}