package com.oving4.oving4.controller;

import com.oving4.oving4.model.CalculationModel;
import com.oving4.oving4.service.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.script.ScriptException;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
public class CalculatorController {
    Logger logger = LoggerFactory.getLogger(CalculatorController.class);
    private CalculatorService calculatorService = new CalculatorService();

    @PostMapping("/")
    public Map<String, String> handlePostRequest(@RequestBody CalculationModel request) throws ScriptException {

        String result = calculatorService.calculate(request);
        logger.trace(result);
        logger.debug(result);
        logger.info(String.valueOf(request));
        logger.warn(String.valueOf(request));
        logger.error(String.valueOf(request));

        Map<String, String> response = new HashMap<String, String>();
        response.put("result", result);
        return response;
    }
}
