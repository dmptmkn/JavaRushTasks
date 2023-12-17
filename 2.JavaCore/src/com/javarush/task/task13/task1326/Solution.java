package com.javarush.task.task13.task1326;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        String fileName = scan.nextLine();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            while (reader.ready()) {
                int i = Integer.parseInt(reader.readLine());
                list.add(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        list.stream().sorted().filter(x -> x % 2 == 0).forEach(System.out::println);
    }
}
