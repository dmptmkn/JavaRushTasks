package com.javarush.task.pro.task15.task1504;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Перепутанные байты
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in);
             InputStream input = Files.newInputStream(Path.of(scanner.nextLine()));
             OutputStream output = Files.newOutputStream(Path.of(scanner.nextLine()))) {
            while (input.available() > 1) {
                int byteInt = input.read();

                output.write(input.read());
                output.write(byteInt);
            }

            if (input.available() == 1) {
                output.write(input.read());
            }
        }
    }
}

