package com.javarush.task.pro.task04.task0417;

import java.util.Scanner;

/* 
Скорость ветра
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int windSpeedMeters = scan.nextInt();
        System.out.println((int)Math.round(windSpeedMeters * 3.6));
    }
}