package com.javarush.task.pro.task07.task0705;

/* 
Бесконечность не предел
*/

public class Solution {
    public static void main(String[] args) {
        div(0.0, 100.0); // infinity
        div(0.0, -100.0); // -infinity
    }

    public static void div(double a, double b){
        System.out.println(b/a);
    }
}
