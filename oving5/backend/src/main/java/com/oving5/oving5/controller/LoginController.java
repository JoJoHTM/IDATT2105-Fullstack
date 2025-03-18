package com.oving5.oving5.controller;

import com.oving5.oving5.model.RegisterModel;
import com.oving5.oving5.repository.DatabaseRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:3000")

@RestController
public class LoginController {
    public int login(@RequestBody RegisterModel model) {
        String username = model.getUsername();
        String password = model.getPassword();
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        return DatabaseRepository.loginUser(username, password);
    }
}
