package com.javarush.task.pro.task15.task1522;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/* 
Получение информации по API
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://javarush.ru/api/1.0/rest/projects");
        URLConnection connection = url.openConnection();

        try (InputStream stream = url.openStream()) {
            byte[] buffer = stream.readAllBytes();
            String str = new String(buffer);
            System.out.println(str);
        }
    }
}