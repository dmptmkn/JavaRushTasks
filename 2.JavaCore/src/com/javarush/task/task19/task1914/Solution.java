package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();
        String[] resultArray = outputStream.toString().split(" ");
        int a = Integer.parseInt(resultArray[0]);
        int b = Integer.parseInt(resultArray[2]);
        char sign = resultArray[1].charAt(0);
        int solution;
        switch (sign) {
            case '+':
                solution = a + b;
                break;
            case '-':
                solution = a - b;
                break;
            case '*':
                solution = a * b;
                break;
            default:
                solution = 0;
        }
        result += solution;
        System.setOut(consoleStream);
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

