package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Map<Integer, Integer> byteMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream inputStream = new FileInputStream(reader.readLine())) {
            while (inputStream.available() > 0) {
                byteMap.merge(inputStream.read(), 1, Integer::sum);
            }
        }

        int minRepetition = byteMap.values().stream().min(Comparator.naturalOrder()).get();
        byteMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == minRepetition)
                .forEach(entry -> System.out.print(entry.getKey() + " "));
    }
}
