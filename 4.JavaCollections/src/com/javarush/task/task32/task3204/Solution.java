package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.Random;

/* 
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream password = new ByteArrayOutputStream();
        Random random = new Random();
        random.ints(3, 48, 58)
                .forEach(i -> password.write((char) i));
        random.ints(3, 65, 91)
                .forEach(i -> password.write((char) i));
        random.ints(2, 97, 123)
                .forEach(i -> password.write((char) i));
        return password;
    }
}
