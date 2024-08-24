package com.javarush.task.jdk13.task41.task4114;

import java.util.HashMap;
import java.util.Map;

public class Calculator {

    private final Map<String, Operation> operationMap = new HashMap<>();

    public Calculator() {
        Processor processor = new Processor();
        operationMap.put("+", processor::plus);
        operationMap.put("-", processor::minus);
        operationMap.put("*", processor::multiply);
        operationMap.put("/", processor::divide);
    }

    public void calculate(int i, String s, int j) {
        if (!operationMap.containsKey(s))
            throw new IllegalStateException(String.format("no operation registered for '%s'", s));

        Operation operation = operationMap.get(s);
        operation.execute(i, j);
    }
}
