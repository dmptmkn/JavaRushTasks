package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        greatestCommonDivisor(a, b);
    }

    public static void greatestCommonDivisor(int a, int b) {
        int i = Math.max(a, b) - Math.min(a, b);
        int j = Math.min(a, b);

        if (Math.min(a, b) / Math.max(a, b) == 1) {
            System.out.println(a);
        } else {
            greatestCommonDivisor(j, i);
        }
    }
}

