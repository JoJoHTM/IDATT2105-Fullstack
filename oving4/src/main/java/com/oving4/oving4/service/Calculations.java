package com.oving4.oving4.service;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;

public class Calculations {
  public static String calculations(ArrayList<String> operations) throws ScriptException {
    ScriptEngineManager manager = new ScriptEngineManager();
    ScriptEngine engine = manager.getEngineByName("js");
    StringBuilder equation = new StringBuilder();
    for (String i: operations) {
      equation.append(i);
    }
    Object result = engine.eval(equation.toString());
    return (String) result;
  }
}
