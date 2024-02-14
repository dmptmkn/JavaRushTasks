package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateFormatOut = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        SimpleDateFormat dateFormatIn = new SimpleDateFormat("dd/MM/yyyy");

        Person person = null;

        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 3) {
                        if (args[i + 1].equals("м")) {
                            person = Person.createMale(args[i], dateFormatIn.parse(args[i + 2]));
                        } else if (args[i + 1].equals("ж")) {
                            person = Person.createFemale(args[i], dateFormatIn.parse(args[i + 2]));
                        }
                        allPeople.add(person);
                        System.out.println(allPeople.size() - 1);
                    }
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 4) {
                        int id = Integer.parseInt(args[i]);
                        if (id >= 0 && id < allPeople.size()) {
                            person = allPeople.get(id);
                            person.setName(args[i + 1]);
                            if (args[i + 2].equals("м")) {
                                person.setSex(Sex.MALE);
                            } else if (args[i + 2].equals("ж")) {
                                person.setSex(Sex.FEMALE);
                            }
                            person.setBirthDate(dateFormatIn.parse(args[i + 3]));
                        }
                    }
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        int id = Integer.parseInt(args[i]);
                        if (id >= 0 && id < allPeople.size()) {
                            person = allPeople.get(id);
                            person.setName(null);
                            person.setBirthDate(null);
                            person.setSex(null);
                        }
                    }
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        int id = Integer.parseInt(args[i]);
                        if (id >= 0 && id < allPeople.size()) {
                            person = allPeople.get(id);
                            System.out.println(person.getName() + " "
                                    + (person.getSex().equals(Sex.MALE) ? "м" : "ж") + " "
                                    + dateFormatOut.format(person.getBirthDate()));
                        }
                    }
                }
                break;
        }
    }
}