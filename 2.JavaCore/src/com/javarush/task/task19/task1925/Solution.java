package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<String> wordList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
             BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))) {
            while (reader.ready()) {
                String[] nextLine = reader.readLine().split(" ");
                for (String word : nextLine) {
                    if (word.length() > 6) {
                        wordList.add(word);
                    }
                }
            }
            for (int i = 0; i < wordList.size() - 1; i++) {
                writer.write(wordList.get(i) + ",");
            }
            writer.write(wordList.get(wordList.size() - 1));
        } catch (Exception e) {
        }
    }
}