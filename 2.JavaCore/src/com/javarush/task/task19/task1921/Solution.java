package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            while (reader.ready()) {
                String[] personInfo = reader.readLine().split("(?<=\\D)\\s(?=[0-9\\s])");
                String name = personInfo[0];
                Date birthDate = new SimpleDateFormat("dd MM yyyy").parse(personInfo[1]);
                PEOPLE.add(new Person(name, birthDate));
            }
        } catch (Exception e) {
        }
    }
}
