package com.javarush.task.pro.task04.task0407;

/* 
Сумма чисел, не кратных 3
*/

public class Solution {
    public static void main(String[] args) {
        int number = 1;
        int sum = 0;

        while (number <= 100) {
            if (number % 3 == 0) {
                number++;
                continue;
            }
            sum += number;
            number++;
        }
        System.out.println(sum);
    }
}