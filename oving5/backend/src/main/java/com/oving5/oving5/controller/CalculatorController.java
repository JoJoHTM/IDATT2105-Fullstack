package com.oving5.oving5.controller;

import com.oving5.oving5.model.CalculationModel;
import com.oving5.oving5.service.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import javax.script.ScriptException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping(value = "/calculator")
@EnableAutoConfiguration
public class CalculatorController {
    Logger logger = LoggerFactory.getLogger(CalculatorController.class);
    private CalculatorService calculatorService = new CalculatorService();

    @PostMapping("/{username}")
    public Map<String, String> handlePostRequest(@PathVariable("username") String username, @RequestBody CalculationModel operations) throws ScriptException {
        System.out.println("handling post request" + username);
        System.out.println(operations.getOperations());
        String result = calculatorService.calculate(username, operations.getOperations());
        Map<String, String> response = new HashMap <String, String>();
        response.put("result", result);
        return response;
    }
}
