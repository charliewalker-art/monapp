package com.example.monapp;

import org.springframework.web.bind.annotation.*;

@RestController
public class Hello {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }



}