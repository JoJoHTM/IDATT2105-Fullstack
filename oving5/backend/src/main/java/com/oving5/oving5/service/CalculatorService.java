package com.oving5.oving5.service;

import com.oving5.oving5.model.CalculationModel;
import com.oving5.oving5.repository.DatabaseRepository;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.List;

public class CalculatorService {

  private final ScriptEngine engine;

  public CalculatorService() {
    ScriptEngineManager manager = new ScriptEngineManager();
    this.engine = manager.getEngineByName("nashorn");
  }
  public String calculate(String username, ArrayList<String> operations) throws ScriptException {
    String equation = String.join("", operations);
    try {
      String solution = engine.eval(equation).toString();
      equation = equation + "=" + solution;
      DatabaseRepository.storeLog(username, equation);
      return solution;
    }
    catch (ScriptException e) {
      return "error";
    }
  }
}
