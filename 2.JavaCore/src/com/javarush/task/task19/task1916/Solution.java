package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader1 = new BufferedReader(new FileReader(console.readLine()));
             BufferedReader reader2 = new BufferedReader(new FileReader(console.readLine()))) {
            while (reader1.ready()) {
                String nextLine1 = reader1.readLine();
                String nextLine2 = reader2.readLine();
                if (nextLine1.equals(nextLine2)) {
                    lines.add(new LineItem(Type.SAME, nextLine1));
                } else if (nextLine1.equals("")) {
                    lines.add(new LineItem(Type.ADDED, nextLine2));
                } else if (nextLine2.equals("")) {
                    lines.add(new LineItem(Type.REMOVED, nextLine1));
                }
            }
        } catch (Exception e) {
        }
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
