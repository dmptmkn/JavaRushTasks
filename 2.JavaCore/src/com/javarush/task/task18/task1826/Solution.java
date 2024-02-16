package com.javarush.task.task18.task1826;

import java.io.*;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) {
        if (args[0].equals("-e")) {
            encryptDecrypt(args[1], args[2], true);
        } else if (args[0].equals("-d")) {
            encryptDecrypt(args[1], args[2], false);
        }
    }

    public static void encryptDecrypt(String filename, String fileOutputName, boolean encrypt) {
        final String ALPHABET = "abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                "абвгдеёжзийклмнопрстуфхцчшщъыьэюя" + "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ" +
                ".,\":!? +-*/\\@#$%^&(){}[];'|`~=_©«»—" + "0123456789";

        int key = encrypt ? 2 : -2;

        try (BufferedReader reader = new BufferedReader(new FileReader(filename));
             BufferedWriter writer = new BufferedWriter(new FileWriter(fileOutputName))) {
            while (reader.ready()) {
                String nextLine = reader.readLine();
                StringBuilder builder = new StringBuilder();
                for (char aChar : nextLine.toCharArray()) {
                    int index = ALPHABET.indexOf(aChar);
                    if (index >= 0) {
                        int newIndex = (index + key) % ALPHABET.length();
                        char charAt = ALPHABET.charAt(newIndex + ((newIndex < 0) ? ALPHABET.length() : 0));
                        builder.append(charAt);
                    }
                }
                writer.write(builder.toString());
                writer.newLine();
            }
        } catch (Exception e) {
        }
    }
}
