package com.manvidas.controllers;

import com.google.gson.Gson;
import com.manvidas.billing.Billing;
import com.manvidas.user.User;
import com.manvidas.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest/billing")
public class BillingController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/single")
    public ResponseEntity<String> single(@RequestBody(required = true) User user, @PathVariable("title") String title, HttpServletRequest request)
    {
        List<User> username = userRepository.findUserByUsername(user.getUsername());
        if (username.get(0) == null){
            return new ResponseEntity<>("No account found under the logged in username", HttpStatus.UNPROCESSABLE_ENTITY);
        }else {
            List<Billing> bills = username.get(0).getBillings();
            Billing bill;

            Map<String, String> tempMap = new HashMap<>();

            bills.forEach(
                    b -> {
                        if (b.getTitle().equals(title)) {
                            tempMap.put("title", b.getTitle());
                            tempMap.put("value", "" + b.getValue());
                            tempMap.put("paid", (b.isPaid() ? "Yes" : "No"));
                        }
                    }
            );

            if (tempMap.size() > 0) {
                return new ResponseEntity<>(new Gson().toJson(tempMap), HttpStatus.OK);
            }

            return new ResponseEntity<>("Could not find a bill under that name", HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/all") //retrieves all bills for a specific user
    public ResponseEntity<String> all(@RequestBody(required = true) String _user, HttpServletRequest request) // takes a json
    {
        User user = new Gson().fromJson(_user, User.class);
        User username = userRepository.findUserByUsername(user.getUsername()).get(0);
        if (username == null){
            return new ResponseEntity<>("No account found under the logged in username", HttpStatus.UNPROCESSABLE_ENTITY);
        }else
        {
            List<Billing> bills = username.getBillings();

            Map<Long, Map<String, String>> arr = new HashMap<>();

            long counter = 0L;
            for (Billing billing : bills) {
                Map<String, String> tempMap = new HashMap<>();
                tempMap.put("title", billing.getTitle());
                tempMap.put("value", ""+billing.getValue());
                tempMap.put("paid", (billing.isPaid() ? "Yes" : "No"));

                arr.put(counter,tempMap);
                counter ++;
            }

            String json = new Gson().toJson(arr);
            return new ResponseEntity<>(json, HttpStatus.OK);
        }

    }
}
