package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {

        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader = new BufferedReader(new FileReader(console.readLine()))) {
            while (reader.ready()) {
                int counter = 0;
                String nextLine = reader.readLine();
                String[] lineToArray = nextLine.split(" ");

                for (int i = 0; i < lineToArray.length; i++) {
                    for (String word : words) {
                        if (word.equals(lineToArray[i])) {
                            counter++;
                        }
                    }
                }

                if (counter == 2) {
                    System.out.println(nextLine);
                }
            }
        } catch (Exception e) {
        }
    }
}
