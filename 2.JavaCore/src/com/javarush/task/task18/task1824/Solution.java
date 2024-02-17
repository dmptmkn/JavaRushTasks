package com.javarush.task.task18.task1824;

import java.io.*;


/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String fileName = console.readLine();
            try {
                FileInputStream inputStream = new FileInputStream(fileName);
                inputStream.close();
            } catch (FileNotFoundException e) {
                System.out.println(fileName);
                break;
            }
        }
        console.close();
    }
}
