package com.javarush.task.task18.task1817;

import java.io.FileReader;
import java.io.IOException;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) {
        int counter = 0;
        int spaceCounter = 0;

        try (FileReader reader = new FileReader(args[0])) {
            while (reader.ready()) {
                int nextByte = reader.read();
                if (nextByte == 32) {
                    spaceCounter++;
                }
                counter++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.printf("%.2f", 1.0 * spaceCounter / counter * 100);
    }
}
