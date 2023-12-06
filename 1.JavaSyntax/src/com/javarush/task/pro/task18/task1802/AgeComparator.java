package com.javarush.task.pro.task18.task1802;

import java.util.Comparator;

/* 
Сортировка по возрасту
*/

public class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        int result = 0;
        if (s1.getAge() > s2.getAge()) {
            result = -1;
        } else if (s1.getAge() < s2.getAge()) {
            result = 1;
        }
        return result;
    }
}
