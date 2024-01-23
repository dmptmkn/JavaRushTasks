package com.javarush.task.task18.task1816;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) {
        int count = 0;

        try (FileReader reader = new FileReader(args[0])) {
            while (reader.ready()) {
                int nextByte = reader.read();
                if (nextByte >= 64 && nextByte <= 90) {
                    count++;
                } else if (nextByte >= 97 && nextByte <= 122) {
                    count++;
                }
            }
        } catch (Exception e) {
        }
        System.out.println(count);
    }
}
