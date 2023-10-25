package com.javarush.task.pro.task04.task0406;

import java.sql.SQLOutput;
import java.util.Scanner;

/* 
Показываем, что получаем
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while(true) {
            String s = scan.nextLine();
            if (s.equals("enough")) {
                break;
            } else {
                System.out.println(s);
            }
        }
    }
}