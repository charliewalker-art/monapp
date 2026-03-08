package com.example.monapp.service;

import org.springframework.stereotype.Service;
import java.util.List;


import com.example.monapp.entity.User;
import com.example.monapp.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    //constructor of the class Hello to inject the UserRepository dependency
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //method to get all users from the database
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // add new user
    public User createUser(String name, String email, String password) {

        User user = new User();

        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

       return userRepository.save(user);
    }



}
