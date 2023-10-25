package com.javarush.task.pro.task04.task0410;

import java.util.Scanner;

/* 
Второе минимальное число из введенных
*/

public class Solution {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int min = scan.nextInt();
        int secondMin = scan.nextInt();

        if (secondMin < min) {
            int temp = secondMin;
            secondMin = min;
            min = temp;
        }

        while (scan.hasNextInt()) {
            int number = scan.nextInt();
            if (min == secondMin && number > min) {
                secondMin = number;
            } else if (number < min) {
                secondMin = min;
                min = number;
            } else if (number > min && number < secondMin) {
                secondMin = number;
            }

        }
        System.out.println(secondMin);
    }
}