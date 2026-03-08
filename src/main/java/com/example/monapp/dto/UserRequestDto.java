package com.example.monapp.dto;

public record UserRequestDto(
        String name,
        String email,
        String password
) {
}