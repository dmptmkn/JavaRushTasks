package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int maxByte = 0;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine());

        while (fileInputStream.available() > 0) {
            int nextByte = fileInputStream.read();
            if (nextByte > maxByte) {
                maxByte = nextByte;
            }
        }
        fileInputStream.close();
        System.out.println(maxByte);
    }
}
