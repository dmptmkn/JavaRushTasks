package com.javarush.task.pro.task13.task1309;

import java.util.HashMap;

/* 
Успеваемость студентов
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
        grades.put("Андрей", 3.6);
        grades.put("Сергей", 4.1);
        grades.put("Виктор", 4.8);
        grades.put("Петр", 3.4);
        grades.put("Анна", 5.0);
    }
}
