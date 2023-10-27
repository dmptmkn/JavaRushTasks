package com.javarush.task.pro.task04.task0416;

import java.util.Scanner;

/* 
Share a Coke
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cansInCase = scan.nextInt();
        int peopleInOffice = scan.nextInt();
        double cansForPerson = (1.0 * cansInCase) / peopleInOffice;
        System.out.println(cansForPerson);
    }
}