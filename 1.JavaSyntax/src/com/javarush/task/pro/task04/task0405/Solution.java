package com.javarush.task.pro.task04.task0405;

/* 
Незаполненный прямоугольник
*/

import java.sql.SQLOutput;

public class Solution {
    public static void main(String[] args) {
        int i = 0;

        while (i < 10) {
            int j = 0;
            while (j < 20) {
                System.out.print("Б");
                j++;
            }
            i++;
            System.out.println();
            while (i > 0 && i < 9) {
                System.out.println("Б                  Б");
                i++;
            }
        }
    }
}