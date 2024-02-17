package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        TreeSet<String> fileNameTree = new TreeSet<>();
        while (true) {
            String nextFileName = console.readLine();
            if (nextFileName.equalsIgnoreCase("end")) break;
            fileNameTree.add(nextFileName);
        }
        console.close();

        String fileName = fileNameTree.first();
        fileName = fileName.substring(0, fileName.lastIndexOf(".part"));
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(fileName))) {
            while (!(fileNameTree.isEmpty())) {
                BufferedInputStream nextInputStream = new BufferedInputStream(new FileInputStream(fileNameTree.pollFirst()));
                while (nextInputStream.available() > 0) {
                    int nextByte = nextInputStream.read();
                    outputStream.write(nextByte);
                    outputStream.flush();
                }
                nextInputStream.close();
            }
        }
    }
}
