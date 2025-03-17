package com.oving5.oving5.controller;

import com.oving5.oving5.model.RegisterModel;
import com.oving5.oving5.repository.DatabaseRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
public class LoginController {

    private final JdbcTemplate jdbcTemplate;

    public LoginController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/login")
    public int login(@RequestBody RegisterModel model) {
        String username = model.getUsername();
        String password = model.getPassword();
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        return DatabaseRepository.loginUser(username, password);
    }
}
