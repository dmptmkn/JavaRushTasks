package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader1 = new BufferedReader(new FileReader(console.readLine()));
             BufferedReader reader2 = new BufferedReader(new FileReader(console.readLine()))) {
            while (reader1.ready()) {
                allLines.add(reader1.readLine());
            }
            while (reader2.ready()) {
                forRemoveLines.add(reader2.readLine());
            }
        } catch (Exception e) {
        }

        Solution solution = new Solution();
        try {
            solution.joinData();
        } catch (CorruptedDataException e) {
        }
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            for (String line : forRemoveLines) {
                allLines.remove(line);
            }
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
