package com.oving5.oving5.repository;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DatabaseRepository {
    private static JdbcTemplate jdbcTemplate;

    public DatabaseRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static int registerUser(String username, String password) {
        try {
            return jdbcTemplate.update("insert into users (UserName, Password) values (?, ?)", username, password);
        }
        catch (DuplicateKeyException e) {
            return 0;
        }
    }

    public static int loginUser(String username, String password) {
        String query = "select UserID from users where UserName=? and Password=?;";

        try {
            return jdbcTemplate.queryForObject(query, Integer.class, username, password);
        } catch (EmptyResultDataAccessException e) {
            return 0;
        }
    }

    public static void storeLog(int id, String equation) {
        String query = "insert into logs (UserID, Equation) values (?,?)";
        jdbcTemplate.update(query, id, equation);
    }

    public static List<String> getLogs(int id) {
        String query = "select Equation from logs where UserID=? order by ID limit 10";
        System.out.println("fetching query");
        System.out.println(jdbcTemplate.queryForList(query, String.class, id));
        return jdbcTemplate.queryForList(query, String.class, id);
    }
}
