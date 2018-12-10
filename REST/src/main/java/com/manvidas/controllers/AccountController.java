package com.manvidas.controllers;

import com.google.gson.Gson;
import com.manvidas.user.User;
import com.manvidas.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.SSLEngine;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/rest")
public class AccountController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody(required = true) User user, HttpServletRequest request) // takes a json
    {
        if (request.getSession().getAttribute("user") == null) {
            if (userRepository.findUserByUsername(user.getUsername()) != null) {
                return new ResponseEntity<String>("Account with that username already exists", HttpStatus.CONFLICT);
            }

            userRepository.save(user);

            return new ResponseEntity<String>("Account has been created successfully", HttpStatus.CREATED);
        }
        return new ResponseEntity<String>("Already logged in", HttpStatus.ALREADY_REPORTED);
    }

    @PostMapping("/login") // returns 404 if account not found || returns () if username and password do not match  || returns 202 (accepted) if account exists
    public ResponseEntity<String> login(@RequestBody(required = true) User user, HttpServletRequest request) // takes a json
    {
        if (request.getSession().getAttribute("user") == null) {
            if (userRepository.findUserByUsername(user.getUsername()) == null) {
                return new ResponseEntity<String>("Account with that username does not exist", HttpStatus.UNPROCESSABLE_ENTITY);
            }

            if (userRepository.findUserByUsername(user.getUsername()) != null) {
                if (userRepository.findUserByUsername(user.getUsername()).get(0).getPassword().toString().equals(user.getPassword().toString())) {
                    request.getSession().setAttribute("user", user.getUsername());
                    return new ResponseEntity<String>(new Gson().toJson(request.getSession()), HttpStatus.OK);
                }
            }

            return new ResponseEntity<String>("Username or password is incorrect", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return new ResponseEntity<String>("Already logged in", HttpStatus.ALREADY_REPORTED);
    }
}
