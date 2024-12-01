package com.example.spring_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class BalanceController {

    @GetMapping("/myBalance")
    public String getWelcomeMessage(){
        return "Balance controller";
    }
}
