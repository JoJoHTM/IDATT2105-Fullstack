package com.oving4.oving4.controller;

import com.oving4.oving4.service.CalculatorService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.script.ScriptException;
import java.util.ArrayList;
@CrossOrigin(origins = "http://localhost:3000")

@RestController
public class CalculatorController {
    @PostMapping("/")
    public String handlePostRequest(@RequestBody ArrayList<String> operations) throws ScriptException {
        // Handle the operations received from the Vue.js frontend
        System.out.println("Received operations: " + operations);
        CalculatorService calculatorService = new CalculatorService();
        String result = calculatorService.calculations(operations);
        // Add your logic here to process the operations
        System.out.println(result);
        return result;
    }
}
