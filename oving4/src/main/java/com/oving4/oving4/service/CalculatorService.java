package com.oving4.oving4.service;

import com.oving4.oving4.model.CalculationModel;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;

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
