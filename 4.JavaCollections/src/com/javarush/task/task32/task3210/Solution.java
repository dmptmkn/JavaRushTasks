package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        String fileName = args[0];
        long number = Long.parseLong(args[1]);
        String text = args[2];

        try (RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw")) {
            randomAccessFile.seek(number);
            byte[] bytes = new byte[text.length()];
            randomAccessFile.read(bytes, 0, text.length());
            String line = new String(bytes);

            randomAccessFile.seek(randomAccessFile.length());
            if (line.equals(text)) {
                randomAccessFile.write("true".getBytes());
            } else {
                randomAccessFile.write("false".getBytes());
            }
        } catch (IOException ignore) {
        }
    }
}
