package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        List<String> file1 = new ArrayList<>();
        List<String> file2 = new ArrayList<>();
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader1 = new BufferedReader(new FileReader(console.readLine()));
             BufferedReader reader2 = new BufferedReader(new FileReader(console.readLine()))) {
            while (reader1.ready()) {
                file1.add(reader1.readLine());
            }
            while (reader2.ready()) {
                file2.add(reader2.readLine());
            }
        } catch (Exception e) {
        }

        while (file1.size() > 0 && file2.size() > 0) {
            if (file1.get(0).equals(file2.get(0))) {
                lines.add(new LineItem(Type.SAME, file1.get(0)));
                file1.remove(0);
                file2.remove(0);
            } else if (file1.get(1).equals(file2.get(0))) {
                lines.add(new LineItem(Type.REMOVED, file1.get(0)));
                file1.remove(0);
            } else {
                lines.add(new LineItem(Type.ADDED, file2.get(0)));
                file2.remove(0);
            }
        }

        if (!(file1.isEmpty())) file1.stream().forEach(s -> lines.add(new LineItem(Type.REMOVED, s)));
        if (!(file2.isEmpty())) file2.stream().forEach(s -> lines.add(new LineItem(Type.ADDED, s)));
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
