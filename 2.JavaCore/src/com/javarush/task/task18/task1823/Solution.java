package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String nextFileName = console.readLine();
            if (nextFileName.equals("exit")) break;
            ReadThread nextReadThread = new ReadThread(nextFileName);
            nextReadThread.start();
        }
    }

    public static class ReadThread extends Thread {
        private FileInputStream inputStream;
        private String filename;

        public ReadThread(String fileName) {
            try {
                this.filename = fileName;
                this.inputStream = new FileInputStream(fileName);
            } catch (Exception e) {
            }
        }

        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {
            Map<Integer, Integer> allBytes = new HashMap<>();
            try {
                while (inputStream.available() > 0) {
                    Integer nextByte = inputStream.read();
                    allBytes.merge(nextByte, 1, Integer::sum);
                }
            } catch (Exception e) {
            }

            Integer maxCount = allBytes.values().stream().max(Comparator.naturalOrder()).get();
            TreeSet<Integer> maxCountBytes = new TreeSet<>();
            allBytes.entrySet().stream()
                    .filter(e -> e.getValue() == maxCount)
                    .forEach(e -> maxCountBytes.add(e.getKey()));
            Integer minMaxCountByte = maxCountBytes.first();
            resultMap.put(filename, minMaxCountByte);
            try {
                inputStream.close();
            } catch (IOException e) {
            }
        }
    }
}
