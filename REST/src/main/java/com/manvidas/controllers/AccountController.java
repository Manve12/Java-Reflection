package com.manvidas.controllers;


import com.manvidas.user.User;
import com.manvidas.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class AccountController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public String register(@RequestBody User user) // takes a json
    {
        if (userRepository.findUserByUsername(user.getUsername()) != null){
            return "[INVALID - Username exists]";
        }

        userRepository.save(user);

        return "New username: "+ user.getUsername();
    }
}
