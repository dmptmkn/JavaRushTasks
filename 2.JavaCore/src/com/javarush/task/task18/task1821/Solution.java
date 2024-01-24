package com.javarush.task.task18.task1821;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) {
        Map<Character, Integer> asciiTree = new TreeMap<>();

        try (FileReader reader = new FileReader(args[0])) {
            while (reader.ready()) {
                asciiTree.merge((char) reader.read(), 1, Integer::sum);
            }
        } catch (Exception e) {
        }

        asciiTree.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
    }
}
