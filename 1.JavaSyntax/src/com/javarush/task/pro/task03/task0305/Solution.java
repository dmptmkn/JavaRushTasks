package com.javarush.task.pro.task03.task0305;

import java.util.Scanner;

/* 
Три числа
*/

public class Solution {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();

        boolean twoEqualsA = a == b && a != c;
        boolean twoEqualsB = a == c && a != b;
        boolean twoEqualsC = b == c && b != a;
        boolean allEquals = a == b && b == c;

        if (twoEqualsA) {
            System.out.println(a + " " + b);
        } else if (twoEqualsB) {
            System.out.println(a + " " + c);
        } else if (twoEqualsC) {
            System.out.println(b + " " + c);
        } else if (allEquals) {
            System.out.println(a + " " + b + " " + c);
        }
    }
}