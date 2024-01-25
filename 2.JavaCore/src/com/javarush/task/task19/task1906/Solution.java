package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) {
        int counter = 1;

        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             FileReader reader = new FileReader(console.readLine());
             FileWriter writer = new FileWriter(console.readLine())) {
            while (reader.ready()) {
                int nextByte = reader.read();
                if (counter % 2 == 0) {
                    writer.write(nextByte);
                }
                counter++;
            }
        } catch (Exception e) {
        }
    }
}
