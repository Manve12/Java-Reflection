package com.manvidas.controllers;

import com.manvidas.core.DatabaseLoader;
import com.manvidas.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/api/login")
    public String login(String username, String password)
    {
        System.out.println(DatabaseLoader.Connect());
        return DatabaseLoader.Connect();
    }
}
