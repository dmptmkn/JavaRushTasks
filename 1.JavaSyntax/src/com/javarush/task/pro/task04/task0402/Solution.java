package com.javarush.task.pro.task04.task0402;

import java.util.Scanner;

/* 
Все любят Мамбу
*/

public class Solution {
    public static void main(String[] args) {
        String text = " любит меня.";
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        int counter = 0;

        while (counter < 10) {
            System.out.println(name + text);
            counter++;
        }
    }
}
