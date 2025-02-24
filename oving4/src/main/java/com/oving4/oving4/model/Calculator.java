package com.oving4.oving4.model;

import com.oving4.oving4.service.Calculations;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.script.ScriptException;
import java.util.ArrayList;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class Calculator {
  @PostMapping("/")
  public void handlePostRequest(@RequestBody ArrayList<String> operations) throws ScriptException {
    // Handle the operations received from the Vue.js frontend
    System.out.println("Received operations: " + operations);
    String result = Calculations.calculations(operations);
    // Add your logic here to process the operations
    System.out.println(result);
  }
}
