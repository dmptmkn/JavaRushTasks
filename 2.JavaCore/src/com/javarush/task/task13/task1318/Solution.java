package com.javarush.task.task13.task1318;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws Exception {
       Scanner scan = new Scanner(System.in);
       try (FileInputStream inStream = new FileInputStream(scan.nextLine());
            InputStreamReader inReader = new InputStreamReader(inStream);
            BufferedReader reader = new BufferedReader(inReader)) {
           while (reader.ready()) {
               String line = reader.readLine();
               System.out.println(line);
           }
        }
       catch (Exception e) {
           e.printStackTrace();
       }
    }
}