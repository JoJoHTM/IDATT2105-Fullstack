package com.oving4.oving4.service;

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
  public String calculations(ArrayList<String> operations) throws ScriptException {
    String equation = String.join("", operations);
    try {
      return engine.eval(equation).toString();
    }
    catch (ScriptException e) {
      return "error";
    }
  }
}
