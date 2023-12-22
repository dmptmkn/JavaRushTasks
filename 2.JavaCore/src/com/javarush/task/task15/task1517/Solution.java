package com.javarush.task.task15.task1517;

/* 
Статики и исключения
*/

public class Solution {
    public static int A = 0;

    static {
        try {
            A = Integer.parseInt("abc");
        } catch (Exception e) {
            throw e;
        }
    }

    public static int B = 5;

    public static void main(String[] args) {
        System.out.println(B);
    }
}
