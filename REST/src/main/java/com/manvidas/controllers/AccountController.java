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
    public ResponseEntity<String> register(@RequestBody(required = true) User user) // takes a json
    {
        if (userRepository.findUserByUsername(user.getUsername()) != null){
            return new ResponseEntity<String>("Account with that username already exists", HttpStatus.CONFLICT);
        }

        userRepository.save(user);

        return new ResponseEntity<String>("Account has been created successfully", HttpStatus.CREATED);
    }

    @PostMapping("/login") // returns 404 if account not found || returns () if username and password do not match  || returns 202 (accepted) if account exists
    public ResponseEntity<String> login(@RequestBody(required = true) User user) // takes a json
    {
        if (userRepository.findUserByUsername(user.getUsername()) == null){
            return new ResponseEntity<String>("Account with that username does not exist", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        if (userRepository.findUserByUsername(user.getUsername()) != null)
        {
            if (userRepository.findUserByUsername(user.getUsername()).get(0).getPassword().toString().equals(user.getPassword().toString()))
            {
                return new ResponseEntity<String>(user.getUsername(), HttpStatus.FOUND);
            }
        }

        return new ResponseEntity<String>("Username or password is incorrect", HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
