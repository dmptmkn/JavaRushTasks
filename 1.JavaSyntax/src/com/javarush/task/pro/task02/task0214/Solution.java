package com.javarush.task.pro.task02.task0214;

import java.util.Scanner;

/* 
Чтение и преобразование строк
*/

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstLine = scan.nextLine();
        String secondLine = scan.nextLine();
        String thirdLine = scan.nextLine();

        System.out.println(thirdLine);
        System.out.println(secondLine.toUpperCase());
        System.out.println(firstLine.toLowerCase());

    }
}
