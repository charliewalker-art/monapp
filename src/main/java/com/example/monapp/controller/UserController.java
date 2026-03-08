package com.example.monapp.controller;

import com.example.monapp.dto.ApiResponse;
import com.example.monapp.dto.UserRequestDto;
import com.example.monapp.dto.UserResponseDto;
import com.example.monapp.service.UserService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    // injection du service
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // get all users
    @GetMapping
    public List<UserResponseDto> showUsers() {
        return userService.getAllUsers();
    }

    // add new user
    @PostMapping
    public ApiResponse createUser(@RequestBody UserRequestDto userRequestDto) {
        return userService.createUser(userRequestDto);
    }

    @GetMapping("/emails")
    public List<String> getEmails() {
        return userService.show_all_mail();
    }
}