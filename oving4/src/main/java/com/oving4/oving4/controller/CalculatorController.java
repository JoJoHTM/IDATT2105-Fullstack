package com.oving4.oving4.controller;

import com.oving4.oving4.model.CalculationModel;
import com.oving4.oving4.service.CalculatorService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.script.ScriptException;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
public class CalculatorController {

    private CalculatorService calculatorService = new CalculatorService();

    @PostMapping("/")
    public String handlePostRequest(@RequestBody CalculationModel request) throws ScriptException {

        String result = calculatorService.calculate(request);
        // Add your logic here to process the operations
        System.out.println(result);
        return result;
    }
}
