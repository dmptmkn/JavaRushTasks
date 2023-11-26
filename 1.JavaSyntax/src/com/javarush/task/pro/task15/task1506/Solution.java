package com.javarush.task.pro.task15.task1506;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/* 
Фейсконтроль
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner console = new Scanner(System.in);
        String strPath = console.nextLine();
        Path path = Paths.get(strPath);
        List<String> list = Files.readAllLines(path);

        for (String str: list) {
            System.out.println(str.replaceAll("[ .,]", ""));
        }

    }
}

