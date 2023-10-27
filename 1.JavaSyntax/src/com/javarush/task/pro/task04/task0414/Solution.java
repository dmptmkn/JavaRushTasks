package com.javarush.task.pro.task04.task0414;

import java.util.Scanner;

/* 
Хорошего не бывает много
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        int number = scan.nextInt();
        int i = 0;

        do {
            if (number > 0 && number < 5) {
                System.out.println(line);
                i++;
            } else {
                System.out.println(line);
                break;
            }
        }
        while (i < number);
    }
}