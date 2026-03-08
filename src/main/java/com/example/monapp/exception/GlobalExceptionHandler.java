package com.example.monapp.exception;

import com.example.monapp.dto.ApiResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ApiResponse handleRuntimeException(RuntimeException ex) {

        return new ApiResponse(
                ex.getMessage(),
                null
        );
    }
}