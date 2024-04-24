package com.javarush.task.jdk13.task35.task3509;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* 
Wildcards для коллекций
*/

public class Solution {

    public static void main(String[] args) {
    }

    public static Double sum(List<? extends Number> list) {
        Double result = 0.0;
        for (int i = 0; i < list.size(); i++) {
            Number numb = list.get(i);
            result += numb.doubleValue();
        }
        return result;
    }

    public static Double multiply(List<? extends Number> list) {
        Double result = 1.0;
        for (int i = 0; i < list.size(); i++) {
            Number numb = list.get(i);
            result *= numb.doubleValue();
        }
        return result;
    }

    public static <T> String concat(List<? extends T> list) {
        StringBuilder builder = new StringBuilder();
        for (Object obj : list) {
            builder.append(obj);
        }
        return builder.toString();
    }

    public static <E> List<E> combine(List<? extends Collection<E>> list) {
        List<E> result = new ArrayList<>();
        for (Collection<E> e : list) {
            result.addAll(e);
        }
        return result;
    }
}
