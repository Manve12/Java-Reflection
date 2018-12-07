package com.manvidas.controllers;

import com.manvidas.user.User;
import com.manvidas.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest")
public class AccountController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) // takes a json
    {
        if (userRepository.findUserByUsername(user.getUsername()) != null){
            return new ResponseEntity<String>("Account with that username already exists", HttpStatus.CONFLICT);
        }

        userRepository.save(user);

        return new ResponseEntity<String>("Account has been created successfully", HttpStatus.CREATED);
    }
}
