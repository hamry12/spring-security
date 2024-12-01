package com.example.spring_security.controller;

import com.example.spring_security.model.Customer;
import com.example.spring_security.repository.CustomerRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@Data
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/registerUser")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer){
        try{
            String hashedPassword=passwordEncoder.encode(customer.getPassword());
            customer.setPassword(hashedPassword);
            customerRepository.save(customer);
            return ResponseEntity.status(HttpStatus.OK).body(
              "User "+customer.getEmail()+" created successfully!!"
            );
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(
                    "An Error Occurred while adding the new user "+e.getMessage()
            );
        }
    }
}
