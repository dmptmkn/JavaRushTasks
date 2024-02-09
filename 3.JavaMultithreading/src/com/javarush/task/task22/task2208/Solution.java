package com.javarush.task.task22.task2208;

import java.util.Map;
import java.util.StringJoiner;

/* 
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static String getQuery(Map<String, String> params) {
        StringJoiner builder = new StringJoiner(" and ");

        params.entrySet().stream().filter(v -> v.getValue() != null)
                .forEach(e -> builder.add(String.format("%s = '%s'", e.getKey(), e.getValue())));

        return builder.toString();
    }
}
