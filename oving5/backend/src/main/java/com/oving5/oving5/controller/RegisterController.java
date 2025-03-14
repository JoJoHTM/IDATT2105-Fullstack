package com.oving5.oving5.controller;

import com.oving5.oving5.model.RegisterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
public class RegisterController {
    Logger logger = Logger.getLogger(RegisterController.class.getName());
    private final JdbcTemplate jdbcTemplate;

    public RegisterController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @PostMapping("/register")
    public String register(@RequestBody RegisterModel registerModel) {
        String username = registerModel.getUsername();
        String password = registerModel.getPassword();
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        try {
            jdbcTemplate.update("insert into users (UserName, Password) values (?, ?)", username, password);
            return "Registration successful";
        }
        catch (DuplicateKeyException e) {
            logger.info("Username already exists");
            return "Username already exists";
        }
    }
}