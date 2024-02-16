package com.javarush.task.task18.task1822;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader = new BufferedReader(new FileReader(console.readLine()))) {
            int id = Integer.parseInt(args[0]);
            while (reader.ready()) {
                String nextLine = reader.readLine();
                String[] nextLineArray = nextLine.split(" ");
                int thisId = Integer.parseInt(nextLineArray[0]);
                if (id == thisId) {
                    System.out.println(nextLine);
                }
            }
        } catch (Exception e) {
        }

    }
}
