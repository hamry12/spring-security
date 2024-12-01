package com.example.spring_security.controller;

import com.example.spring_security.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class AccountController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/myAccount")
    public String getAccountDetails(){
        return "Welcome to Spring Security!!!";

    }
}
