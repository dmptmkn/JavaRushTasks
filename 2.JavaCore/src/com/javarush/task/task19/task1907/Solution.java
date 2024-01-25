package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) {
        int counter = 0;

        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader = new BufferedReader(new FileReader(console.readLine()))) {
            while (reader.ready()) {
                String[] line = reader.readLine().split(("\\W"));
                for (String s : line) {
                    if (s.equals("world")) {
                        counter++;
                    }
                }
            }
        } catch (Exception e) {
        }
        System.out.println(counter);
    }
}
