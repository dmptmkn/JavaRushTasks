package com.javarush.task.task26.task2601;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/* 
Почитать в инете про медиану выборки
*/

public class Solution {

    public static void main(String[] args) {
    }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);

        int median;
        if (array.length % 2 != 0) {
            median = array[array.length / 2];
        } else {
            median = (array[(array.length / 2 - 1)] + array[array.length / 2]) / 2;
        }

        Arrays.sort(array, Comparator.comparingInt(i -> Math.abs(median - i)));
        return array;
    }
}
