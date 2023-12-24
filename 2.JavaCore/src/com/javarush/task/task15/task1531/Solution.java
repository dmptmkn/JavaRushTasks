package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        if (n < 0) {
            return "0";
        }

        int[] factorialArray = new int[n];
        BigDecimal result = new BigDecimal(1);

        for (int i = 1; i <= factorialArray.length; i++) {
            factorialArray[i - 1] = i;
        }

        for (int i = 0; i < factorialArray.length; i++) {
            result = result.multiply(BigDecimal.valueOf(factorialArray[i]));
        }

        return String.valueOf(result);
    }
}
