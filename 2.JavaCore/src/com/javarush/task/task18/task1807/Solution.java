package com.javarush.task.task18.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int commaCount = 0;

        while (inputStream.available() > 0) {
            int nextByte = inputStream.read();
            if (nextByte == 44) {
                commaCount++;
            }
        }
        inputStream.close();

        System.out.println(commaCount);
    }
}
