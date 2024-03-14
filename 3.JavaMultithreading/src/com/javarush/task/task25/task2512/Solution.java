package com.javarush.task.task25.task2512;

import java.util.LinkedList;
import java.util.List;

/* 
Живем своим умом
*/

public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        try {
            uncaughtException(t, e.getCause());
            System.out.println(e.toString());
        } catch (NullPointerException ex) {
            t.interrupt();
        }
    }

    public static void main(String[] args) {
    }
}
