package com.javarush.task.pro.task16.task1612;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/* 
Синтезируем LocalDateTime
*/

public class Solution {

    public static void main(String[] args) {
        Map<LocalDate, List<LocalTime>> dateMap = DateTimeGenerator.generateDateMap();
        printCollection(dateMap.entrySet());

        Set<LocalDateTime> dateSet = convert(dateMap);
        printCollection(dateSet);
    }

    static Set<LocalDateTime> convert(Map<LocalDate, List<LocalTime>> sourceMap) {
        Set<LocalDateTime> dateTimeSet = new HashSet<>();

        for (LocalDate dateEntry : sourceMap.keySet()) {
            List<LocalTime> timeList = sourceMap.get(dateEntry);
            for (LocalTime timeEntry : timeList) {
                LocalDateTime newDateTimeSetEntry = LocalDateTime.of(dateEntry, timeEntry);
                dateTimeSet.add(newDateTimeSetEntry);
            }
        }
        return dateTimeSet;
    }

    static void printCollection(Collection<?> collection) {
        System.out.println("-----------------------------------------------------");
        collection.forEach(System.out::println);
    }
}