package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream inputStream = new FileInputStream(reader.readLine());
             FileOutputStream outputStream = new FileOutputStream(reader.readLine())) {
            List<Integer> byteList = new ArrayList<>();
            while (inputStream.available() > 0) {
                int nextByte = inputStream.read();
                byteList.add(nextByte);
            }
            Collections.reverse(byteList);
            for (Integer i : byteList) {
                outputStream.write(i);
            }
        }
    }
}
