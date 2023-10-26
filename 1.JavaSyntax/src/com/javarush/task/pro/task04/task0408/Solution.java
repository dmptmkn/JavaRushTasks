package com.javarush.task.pro.task04.task0408;

import java.util.Scanner;

/* 
Максимум из введенных чисел
*/

public class Solution {
    public static void main(String[] args) {
        int max = Integer.MIN_VALUE;
        int number;
        Scanner scan = new Scanner(System.in);

        while (scan.hasNextInt()) {
            number = scan.nextInt();
            if (number % 2 == 0 && number > max) {
                max = number;
            }
        }
        System.out.println(max);
    }
}