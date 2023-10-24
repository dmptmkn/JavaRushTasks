package com.javarush.task.pro.task03.task0308;

import java.util.Scanner;

/* 
Координатные четверти
*/

public class Solution {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        int y = scan.nextInt();

        boolean firstQuarter = (x > 0 && y > 0);
        boolean secondQuarter = (x < 0 && y > 0);
        boolean thirdQuarter = (x < 0 && y < 0);
        boolean fourthQuarter = (x > 0 && y < 0);

        if (firstQuarter)
            System.out.println("1");
        else if (secondQuarter)
            System.out.println("2");
        else if (thirdQuarter)
            System.out.println("3");
        else if (fourthQuarter)
            System.out.println("4");
    }
}
