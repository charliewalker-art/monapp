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

        if (name == null || name.isBlank()) {
            throw new RuntimeException("Name is required");
        }

        if (email == null || email.isBlank()) {
            throw new RuntimeException("Email is required");
        }

        if (password.length() < 6) {
            throw new RuntimeException("Password must be at least 6 characters");
        }

        User user = new User();

        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        return userRepository.save(user);
    }


    public List<String> show_all_mail() {
        return userRepository.show_all_mail();
    }


}
