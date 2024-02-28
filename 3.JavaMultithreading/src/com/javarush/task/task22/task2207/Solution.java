package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/* 
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {
        String fileName = null;
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = console.readLine();
        } catch (Exception e) {
        }

        List<String> words = new ArrayList<>();

        try {
            words = Files.readAllLines(Paths.get(fileName)).stream()
                    .flatMap(s -> Arrays.stream(s.split("\\s")))
                    .collect(Collectors.toList());
        } catch (Exception e) {
        }

        for (int i = 0; i < words.size(); i++) {
            String reverse = new StringBuilder(words.get(i)).reverse().toString();
            if (words.contains(reverse) && words.lastIndexOf(reverse) != i) {
                result.add(new Pair(words.get(i), words.get(words.indexOf(reverse))));
                words.remove(i);
                words.remove(reverse);
                i--;
            }
        }
    }

    public static class Pair {
        String first;
        String second;

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        public Pair() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
