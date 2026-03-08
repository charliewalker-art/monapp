package com.example.monapp.dto;

public record ApiResponse(
        String message,
        Object data
) {
}