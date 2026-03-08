package com.example.monapp.service;

import com.example.monapp.dto.ApiResponse;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

import com.example.monapp.dto.UserRequestDto;
import com.example.monapp.dto.UserResponseDto;
import com.example.monapp.entity.User;
import com.example.monapp.repository.UserRepository;


@Service
public class UserService {

    private final UserRepository userRepository;

    // injection du repository
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // get all users
    public List<UserResponseDto> getAllUsers() {
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(user -> new UserResponseDto(
                        user.getId(),
                        user.getName(),
                        user.getEmail()
                ))
                .collect(Collectors.toList());
    }

    // add new user
    public ApiResponse createUser(UserRequestDto userRequestDto) {

        try {

            if (userRequestDto.name() == null || userRequestDto.name().isBlank()) {
                throw new Exception("Name is required");
            }

            if (userRequestDto.email() == null || userRequestDto.email().isBlank()) {
                throw new Exception("Email is required");
            }

            if (userRequestDto.password() == null || userRequestDto.password().length() < 6) {
                throw new Exception("Password must be at least 6 characters");
            }

            User user = new User();

            user.setName(userRequestDto.name());
            user.setEmail(userRequestDto.email());
            user.setPassword(userRequestDto.password());

            User savedUser = userRepository.save(user);

            UserResponseDto userResponse = new UserResponseDto(
                    savedUser.getId(),
                    savedUser.getName(),
                    savedUser.getEmail()
            );

            return new ApiResponse(
                    "User created successfully",
                    userResponse
            );

        } catch (Exception e) {

            return new ApiResponse(
                    e.getMessage(),
                    null
            );

        }
    }

    public List<String> show_all_mail() {
        return userRepository.show_all_mail();
    }
}