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
        Scanner console = new Scanner(System.in);

        try (InputStream inputStream = Files.newInputStream(Paths.get(console.nextLine()));
             OutputStream outputStream = Files.newOutputStream(Paths.get(console.nextLine()))) {
        }


    }
}

