package com.javarush.task.pro.task16.task1601;

import java.util.Calendar;
import java.util.Date;

/* 
Лишь бы не в понедельник :)
*/

public class Solution {

    static Date birthDate = new Date(89, 3, 29);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Date date) {
        int dayOfTheWeek = date.getDay();
        String dayOfTheWeekRu = null;
        switch (dayOfTheWeek) {
            case 0:
                dayOfTheWeekRu = "воскресенье";
                break;
            case 1:
                dayOfTheWeekRu = "понедельник";
                break;
            case 2:
                dayOfTheWeekRu = "вторник";
                break;
            case 3:
                dayOfTheWeekRu = "среда";
                break;
            case 4:
                dayOfTheWeekRu = "четверг";
                break;
            case 5:
                dayOfTheWeekRu = "пятница";
                break;
            case 6:
                dayOfTheWeekRu = "суббота";
                break;
        }
        return dayOfTheWeekRu;
    }
}
