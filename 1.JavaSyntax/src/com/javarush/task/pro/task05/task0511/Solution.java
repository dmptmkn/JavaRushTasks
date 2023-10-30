package com.javarush.task.pro.task05.task0511;

import java.util.Scanner;

/* 
Создаем двумерный массив
*/

public class Solution {
    public static int[][] multiArray;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int columns = scan.nextInt();
        multiArray = new int[columns][];
        int[] rows = new int[columns];

        for (int i = 0; i < rows.length; i++) {
            rows[i] = scan.nextInt();
            multiArray[i] = new int[rows[i]];
        }
    }
}
