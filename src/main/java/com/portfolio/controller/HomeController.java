package com.portfolio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller handles requests to the root path of the application.
 */
@RestController
public class HomeController {

    /**
     * Handles GET requests to the "/" endpoint.
     * @return a simple string message indicating the application is running.
     */
    @GetMapping("/")
    public String home() {
        return "Welcome to the Spring Boot Application!";
    }
}
