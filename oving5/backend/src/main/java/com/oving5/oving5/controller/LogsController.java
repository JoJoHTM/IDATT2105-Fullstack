package com.oving5.oving5.controller;

import com.oving5.oving5.model.LogsModel;
import com.oving5.oving5.repository.DatabaseRepository;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping(value = "/getLogs")
@EnableAutoConfiguration
public class LogsController {

    public List<String> logs;

    @GetMapping("/{userName}")
    public List<String> getLogs(@PathVariable("userName") String userName) {
        if (logs != null) {
            logs.clear();
        }
        System.out.println("meow");
        logs = DatabaseRepository.getLogs(userName);
        System.out.println("reached getLogs method");
        return logs;
    }

}
