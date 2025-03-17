package com.oving5.oving5.service;

import com.oving5.oving5.model.CalculationModel;
import com.oving5.oving5.repository.DatabaseRepository;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class CalculatorService {

  private final ScriptEngine engine;

  public CalculatorService() {
    ScriptEngineManager manager = new ScriptEngineManager();
    this.engine = manager.getEngineByName("nashorn");
  }
  public String calculate(CalculationModel request) throws ScriptException {
    String equation = String.join("", request.getOperations());
    try {
      String solution = engine.eval(equation).toString();
      equation = equation + "=" + solution;
      DatabaseRepository.storeLog(request.getId(), equation);
      return solution;
    }
    catch (ScriptException e) {
      return "error";
    }
  }
}
