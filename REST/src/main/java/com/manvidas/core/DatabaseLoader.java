package com.manvidas.core;

import com.manvidas.billing.Billing;
import com.manvidas.billing.BillingRepository;
import com.manvidas.user.User;
import com.manvidas.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseLoader implements ApplicationRunner {
    private final UserRepository users;
    private final BillingRepository billings;

    @Autowired
    public DatabaseLoader(UserRepository users, BillingRepository billings) {
        this.users = users;
        this.billings = billings;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //create new user
        User user = new User("username","password");
        users.save(user);

        Billing bill_1 = new Billing("Electricity", 124.23, false, user);
        Billing bill_2 = new Billing("Gas", 687.64, true, user);


        billings.save(bill_1);
        billings.save(bill_2);

        user.addBilling(bill_1);
        user.addBilling(bill_2);

        users.save(user);
    }
}
