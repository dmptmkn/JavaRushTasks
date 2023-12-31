package com.javarush.task.task15.task1525;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static {
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(Statics.FILE_NAME))) {
            while (reader.ready()) {
                line = reader.readLine();
                lines.add(line);
            }
        } catch (Exception e) {
            e.getCause();
        }
    }

    public static void main(String[] args) throws IOException, FileNotFoundException {
        System.out.println(lines);
    }
}
