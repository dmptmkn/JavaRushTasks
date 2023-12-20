package com.javarush.task.task14.task1419;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.*;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) throws Exception {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() throws IOException {   //the first exception
        try {
            float i = 1 / 0;
        } catch (ArithmeticException arithmeticException) {
            exceptions.add(arithmeticException);
        }

        try {
            int[] array = new int[10];
            array[11] = 20;
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            exceptions.add(indexOutOfBoundsException);
        }

        try {
            Stack<Integer> stack = new Stack<>();
            stack.pop();
        } catch (EmptyStackException emptyStackException) {
            exceptions.add(emptyStackException);
        }

        try {
            String s = null;
            s.split("");
        } catch (NullPointerException nullPointerException) {
            exceptions.add(nullPointerException);
        }
        
        try {
            String s = "abcd";
            s.charAt(5);
        } catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
            exceptions.add(stringIndexOutOfBoundsException);
        }

        try {
            int i = Integer.parseInt("строка");
        } catch (NumberFormatException numberFormatException) {
            exceptions.add(numberFormatException);
        }

        try {
            int[] array = new int[-1];
        } catch (NegativeArraySizeException negativeArraySizeException) {
            exceptions.add(negativeArraySizeException);
        }

        try {
            Object[] x = new String[3];
            x[0] = new Integer(0);
        } catch (ArrayStoreException arrayStoreException) {
            exceptions.add(arrayStoreException);
        }

        try {
            Object x = new String();
            Object y = (Integer) x;
        } catch (ClassCastException classCastException) {
            exceptions.add(classCastException);
        }

        try {
            String file = "abcd";
            FileInputStream in = new FileInputStream(file);
        } catch (IOException ioException) {
            exceptions.add(ioException);
        }
    }
}
