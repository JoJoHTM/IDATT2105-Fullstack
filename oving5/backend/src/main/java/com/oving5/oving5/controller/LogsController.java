package com.oving5.oving5.controller;

import com.oving5.oving5.model.LogsModel;
import com.oving5.oving5.repository.DatabaseRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
public class LogsController {

    public List<String> logs;

    @PostMapping("/getLogs")
    public List<String> getLogs(@RequestBody LogsModel request) {
        if (logs != null) {
            logs.clear();
        }
        logs = DatabaseRepository.getLogs(request.getId());
        System.out.println("reached getLogs method");
        return logs;
    }

}
