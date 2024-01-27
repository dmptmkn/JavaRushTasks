package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        TreeSet<Integer> byteTree = new TreeSet<>();

        while (inputStream.available() > 0) {
            int nextByte = inputStream.read();
            byteTree.add(nextByte);
        }
        inputStream.close();
        for (Integer i : byteTree) {
            System.out.print(i + " ");
        }
    }
}
