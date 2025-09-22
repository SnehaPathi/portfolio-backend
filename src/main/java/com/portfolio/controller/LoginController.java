package com.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.portfolio.model.loginmodel;
import com.portfolio.service.loginservice;

@RestController
// CORRECTED: Updated the base path to include the Tomcat context root 'springapp1'
// to match the URL sent by the frontend application.
@RequestMapping("/springapp1/api")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

    @Autowired
    private loginservice loginservice;

    @PostMapping("/signup")
    public String signup(@RequestBody loginmodel user) {
        try {
            loginservice.registerUser(user.getUsername(), user.getPassword());
            return "Signup successful";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody loginmodel user) {
        boolean success = loginservice.loginUser(user.getUsername(), user.getPassword());
        return success ? "Login successful" : "Invalid credentials";
    }
}
