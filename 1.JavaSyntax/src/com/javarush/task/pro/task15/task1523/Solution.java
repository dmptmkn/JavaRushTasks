package com.javarush.task.pro.task15.task1523;

import java.io.*;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;

/* 
Получение информации по API
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://httpbin.org/post");
        URLConnection connection = url.openConnection();

        try (OutputStream outputStream = connection.getOutputStream()) {
            connection.setDoOutput(true);
        }

        try (InputStream inputStream = connection.getInputStream()) {
            byte[] buffer = inputStream.readAllBytes();
            String str = new String(buffer);
            System.out.println(str);
        }
    }
}

