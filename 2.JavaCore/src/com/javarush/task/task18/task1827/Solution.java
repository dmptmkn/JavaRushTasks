package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* 
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName = null;
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = console.readLine();
        } catch (Exception e) {
        }

        List<Integer> idList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                String nextLine = reader.readLine();
                Integer nextId = Integer.parseInt(nextLine.substring(0, 8).trim());
                idList.add(nextId);
            }
        }

        int id = idList.stream().max(Comparator.naturalOrder()).get() + 1;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            if (args[0].equals("-c")) {
                StringBuilder newProduct = new StringBuilder();
                newProduct.append(id);
                while (newProduct.length() < 8) {
                    newProduct.append(" ");
                }
                newProduct.append(args[1]);
                while (newProduct.length() < 38) {
                    newProduct.append(" ");
                }
                newProduct.append(args[2]);
                while (newProduct.length() < 46) {
                    newProduct.append(" ");
                }
                newProduct.append(args[3]);
                while (newProduct.length() < 50) {
                    newProduct.append(" ");
                }
                writer.newLine();
                writer.write(newProduct.toString());
            }
        } catch (Exception e) {
        }
    }
}
