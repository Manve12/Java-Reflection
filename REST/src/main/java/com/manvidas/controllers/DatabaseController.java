package com.manvidas.controllers;

import com.manvidas.billing.BillingRepository;
import com.manvidas.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabaseController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BillingRepository billingRepository;
}
