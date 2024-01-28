package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Самый богатый
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Double> salaryMap = new TreeMap<>();
        Set<String> salarySet = new TreeSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            while (reader.ready()) {
                String[] line = reader.readLine().split(" ");
                String name = line[0];
                Double salary = Double.parseDouble(line[1]);
                salaryMap.merge(name, salary, Double::sum);
            }
        } catch (Exception e) {
        }

        double maxSalary = salaryMap.values().stream().max(Comparator.naturalOrder()).get();
        salaryMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == maxSalary)
                .forEach(entry -> salarySet.add(entry.getKey()));

        salarySet.forEach(System.out::println);
    }
}
