package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String[] strings1 = url.split("\\?");
        String[] strings2 = strings1[1].split("&");

        for (String s : strings2) {
            String[] strings3 = s.split("=.+");
            System.out.print(strings3[0] + " ");
        }

        for (String s : strings2) {
            if (s.contains("obj")) {
                System.out.println();
                try {
                    alert(Double.parseDouble(s.substring(s.indexOf("=") + 1)));
                } catch (Exception e) {
                    alert(s.substring(s.indexOf("=") + 1));
                }
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
