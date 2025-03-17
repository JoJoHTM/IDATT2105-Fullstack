package com.oving5.oving5.controller;

import com.oving5.oving5.model.RegisterModel;
import com.oving5.oving5.repository.DatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
public class RegisterController {
    Logger logger = Logger.getLogger(RegisterController.class.getName());


    @PostMapping("/register")
    public String register(@RequestBody RegisterModel registerModel) {
        String username = registerModel.getUsername();
        String password = registerModel.getPassword();
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        if (DatabaseRepository.registerUser(username,password) != 0) {
            return "Registration successfully";
        }
        else {
            return "Username already exists";
        }
    }
}