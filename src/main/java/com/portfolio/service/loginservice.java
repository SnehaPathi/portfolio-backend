package com.portfolio.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.model.loginmodel;
import com.portfolio.repository.loginrepo;

@Service
public class loginservice {

    @Autowired
    private loginrepo userRepository;

    // Store password as plain text
    public loginmodel registerUser(String username, String password) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("Username already exists");
        }
        loginmodel user = new loginmodel(username, password);
        return userRepository.save(user);
    }

    public boolean loginUser(String username, String password) {
        Optional<loginmodel> userOpt = userRepository.findByUsername(username);
        return userOpt.map(user -> user.getPassword().equals(password)).orElse(false);
    }
}
