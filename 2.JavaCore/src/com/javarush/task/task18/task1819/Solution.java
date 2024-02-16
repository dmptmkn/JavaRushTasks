package com.javarush.task.task18.task1819;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) {
        List<String> allLines = new ArrayList<>();
        String file1 = null;
        String file2 = null;
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            file1 = console.readLine();
            file2 = console.readLine();
        } catch (Exception e) {
        }

        String nextLine = null;
        try (BufferedReader reader1 = new BufferedReader(new FileReader(file1));
             BufferedReader reader2 = new BufferedReader(new FileReader(file2));
             BufferedWriter writer = new BufferedWriter(new FileWriter(file1))) {
            while (reader2.ready()) {
                nextLine = reader2.readLine();
                allLines.add(nextLine);
            }
            while (reader1.ready()) {
                nextLine = reader1.readLine();
                allLines.add(nextLine);
            }
            for (String line : allLines) {
                writer.write(line);
            }
        } catch (Exception e) {
        }
    }
}
