package com.example.monapp.controller;

import com.example.monapp.service.UserService;
import com.example.monapp.entity.User;


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
    public List<User> showUsers() {
        return userService.getAllUsers();
    }

    // add  mew user
    @PostMapping
    public User createUser(@RequestBody User user) {

        return userService.createUser(
                user.getName(),
                user.getEmail(),
                user.getPassword()
        );
    }

}
