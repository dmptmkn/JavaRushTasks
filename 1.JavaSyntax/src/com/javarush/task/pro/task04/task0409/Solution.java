package com.javarush.task.pro.task04.task0409;

import java.util.Scanner;

/* 
Минимум из введенных чисел
*/

public class Solution {
    public static void main(String[] args) {
        int number;
        int min = Integer.MAX_VALUE;
        Scanner scan = new Scanner(System.in);

        while (scan.hasNextInt()) {
            number = scan.nextInt();
            if (number < min) {
                min = number;
            }
        }
        System.out.println(min);
    }
}