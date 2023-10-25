package com.javarush.task.pro.task04.task0403;

import java.util.Scanner;

/* 
Суммирование
*/

public class Solution {
    public static void main(String[] args) {
        int number;
        int sum = 0;
        String line;
        boolean isExit = false;
        Scanner scan = new Scanner(System.in);

        while (!isExit) {
            while (scan.hasNextInt()) {
                number = scan.nextInt();
                sum += number;
            }
            line = scan.nextLine();
            isExit = line.equals("ENTER");
        }
        System.out.println(sum);
    }
}