package com.oving5.oving5.controller;

import com.oving5.oving5.model.RegisterModel;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
public class LoginController {

    private final JdbcTemplate jdbcTemplate;

    public LoginController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/login")
    public String login(@RequestBody RegisterModel model) {
        String username = model.getUsername();
        String password = model.getPassword();
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

        String query = "select UserID from users where UserName=? and Password=?;";

        try {
            int id = jdbcTemplate.queryForObject(query, Integer.class, username, password);
            return "Login successful";
        } catch (EmptyResultDataAccessException e) {
            return "Invalid username or password";
        }
    }
}
