package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы 2
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = null;
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
           fileName = console.readLine();
        }

        List<String> products = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                String nextProduct = reader.readLine();
                products.add(nextProduct);
            }
        }

        if (args[0].equals("-u")) {
            for (String product : products) {
                int productId = Integer.parseInt(product.substring(0, 8).trim());
                if (productId == Integer.parseInt(args[1].trim())) {
                    StringBuilder updatedProduct = new StringBuilder();
                    updatedProduct.append(String.format("%-8s", args[1]));
                    updatedProduct.append(String.format("%-30s", args[2]));
                    updatedProduct.append(String.format("%-8s", args[3]));
                    updatedProduct.append(String.format("%-4s", args[4]));
                    int index = products.indexOf(product);
                    products.set(index, updatedProduct.toString());
                }
            }
        } else if (args[0].equals("-d")) {
            for (String product : products) {
                int productId = Integer.parseInt(product.substring(0, 8).trim());
                if (productId == Integer.parseInt(args[1].trim())) {
                    products.remove(product);
                }
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String product : products) {
                writer.write(product);
                writer.newLine();
            }
        }
    }
}
