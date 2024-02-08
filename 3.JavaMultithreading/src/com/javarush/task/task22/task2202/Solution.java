package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

public class Solution {
    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        String[] sub;
        String result;
        try {
            sub = string.split(" ");
            result = String.format("%s %s %s %s",sub[1],sub[2],sub[3],sub[4]);
        } catch (Throwable e) {
            throw new TooShortStringException();
        }
        return result;
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
