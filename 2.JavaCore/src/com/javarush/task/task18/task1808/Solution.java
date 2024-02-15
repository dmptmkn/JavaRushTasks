package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream inputStream = new FileInputStream(reader.readLine());
             FileOutputStream outputStream1 = new FileOutputStream(reader.readLine());
             FileOutputStream outputStream2 = new FileOutputStream(reader.readLine())) {
                byte[] buffer = new byte[1000];
                while (inputStream.available() > 0) {
                    int count = inputStream.read(buffer);
                    int thisCount = count % 2 == 0 ? count / 2 : count / 2 + 1;
                    outputStream1.write(buffer, 0, thisCount);
                    outputStream2.write(buffer, thisCount, count / 2);
            }
        }
    }   
}
