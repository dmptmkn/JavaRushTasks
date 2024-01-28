package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Double> salaryTree = new TreeMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            while (reader.ready()) {
                String[] line = reader.readLine().split(" ");
                String name = line[0];
                Double salary = Double.parseDouble(line[1]);
                salaryTree.merge(name, salary, Double::sum);
            }
        } catch (IOException e) {
        }
        salaryTree.entrySet().forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
    }
}
