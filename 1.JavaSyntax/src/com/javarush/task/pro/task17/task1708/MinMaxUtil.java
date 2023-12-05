package com.javarush.task.pro.task17.task1708;

/* 
Минимальное и максимальное
*/

import java.util.Arrays;

public class MinMaxUtil {

    public static int min(int a, int b) {
        return Math.min(a, b);
    }

    public static int min(int a, int b, int c) {
        int[] array = {a, b, c};
        Arrays.sort(array);
        return array[0];
    }

    public static int min(int a, int b, int c, int d) {
        int[] array = {a, b, c, d};
        Arrays.sort(array);
        return array[0];
    }

    public static int min(int a, int b, int c, int d, int e) {
        int[] array = {a, b, c, d, e};
        Arrays.sort(array);
        return array[0];
    }

    public static int max(int a, int b) {
        return Math.max(a, b);
    }

    public static int max(int a, int b, int c) {
        int[] array = {a, b, c};
        Arrays.sort(array);
        return array[2];
    }

    public static int max(int a, int b, int c, int d) {
        int[] array = {a, b, c, d};
        Arrays.sort(array);
        return array[3];
    }

    public static int max(int a, int b, int c, int d, int e) {
        int[] array = {a, b, c, d, e};
        Arrays.sort(array);
        return array[4];
    }
}
