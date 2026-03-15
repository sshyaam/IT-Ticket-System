package com.example.ticketing.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ticketing.dto.AppInfo;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }

    @GetMapping("/info")
    public AppInfo getInfo() {
        return new AppInfo("Ticket System", "1.0.0", "Running");
    }
     
}