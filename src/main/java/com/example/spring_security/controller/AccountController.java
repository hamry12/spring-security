package com.example.spring_security.controller;

import com.example.spring_security.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class AccountController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/myAccount")
    public ResponseEntity<String> getAccountDetails(){
        return ResponseEntity.status(HttpStatus.OK).body("Welcome to Spring Security!!!");

    }
}
