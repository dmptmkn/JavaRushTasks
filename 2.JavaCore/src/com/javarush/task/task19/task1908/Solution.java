package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.Arrays;


/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader = new BufferedReader(new FileReader(console.readLine()));
             BufferedWriter writer = new BufferedWriter(new FileWriter(console.readLine()))) {
            while (reader.ready()) {
                String[] line = reader.readLine().split(" ");
                for (String s : line) {
                    if (s.matches("\\b\\d+\\b")) {
                        writer.write(s + " ");
                    }
                }
            }
        } catch (Exception e) {
        }
    }
}
