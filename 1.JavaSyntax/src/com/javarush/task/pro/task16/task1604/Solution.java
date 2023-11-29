package com.javarush.task.pro.task16.task1604;

import java.util.Calendar;
import java.util.GregorianCalendar;

/* 
День недели рождения твоего
*/

public class Solution {

    static Calendar birthDate = new GregorianCalendar(1989, Calendar.APRIL, 29);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Calendar calendar) {
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        String dayOfWeek = null;
        switch (day) {
            case 1:
                dayOfWeek = "воскресенье";
                break;
            case 2:
                dayOfWeek = "понедельник";
                break;
            case 3:
                dayOfWeek = "вторник";
                break;
            case 4:
                dayOfWeek = "среда";
                break;
            case 5:
                dayOfWeek = "четверг";
                break;
            case 6:
                dayOfWeek = "пятница";
                break;
            case 7:
                dayOfWeek = "суббота";
        }
        return dayOfWeek;
    }
}
