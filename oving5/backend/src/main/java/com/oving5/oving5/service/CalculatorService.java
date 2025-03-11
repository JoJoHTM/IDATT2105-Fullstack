package com.oving5.oving5.service;

import com.oving5.oving5.model.CalculationModel;

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
      return engine.eval(equation).toString();
    }
    catch (ScriptException e) {
      return "error";
    }
  }
}
