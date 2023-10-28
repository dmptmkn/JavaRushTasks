package com.javarush.task.pro.task05.task0506;

import java.util.Scanner;

/* 
Минимальное из N чисел
*/

public class Solution {
    public static int[] array;

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        array = new int[n];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            int number = scan.nextInt();
            array[i] = number;
            if (array[i] < min) {
                min = array[i];
            }
        }
        System.out.println(min);
    }
}
