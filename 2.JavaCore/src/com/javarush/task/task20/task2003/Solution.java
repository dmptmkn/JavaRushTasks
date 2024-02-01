package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/

public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        PrintWriter writer = new PrintWriter(outputStream);
        Properties properties = new Properties();

        if (runtimeStorage != null) {
            for (Map.Entry<String, String> entry : runtimeStorage.entrySet()) {
                properties.setProperty(entry.getKey(), entry.getValue());
            }
            properties.store(writer, "runtimeStorage HashMap");
        }

    }

    public static void load(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        Properties properties = new Properties();

        while (reader.ready()) {
            properties.load(reader);
        }

        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            runtimeStorage.put((String) entry.getKey(), (String) entry.getValue());
        }
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fos = new FileInputStream(reader.readLine())) {
            load(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(runtimeStorage);
    }
}
