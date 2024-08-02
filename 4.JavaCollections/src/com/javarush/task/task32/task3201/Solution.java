package com.javarush.task.task32.task3201;

import java.io.RandomAccessFile;

/* 
Запись в существующий файл
*/

public class Solution {
    public static void main(String... args) {
        String fileName = args[0];
        long number = Long.parseLong(args[1]);
        String text = args[2];

        try (RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw")) {
            long seek = number < randomAccessFile.length() ? number : randomAccessFile.length();
            randomAccessFile.seek(seek);
            randomAccessFile.write(text.getBytes());
        } catch (Exception ignore) {
        }
    }
}
