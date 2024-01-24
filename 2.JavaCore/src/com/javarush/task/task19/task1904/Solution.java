package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String[] personData = fileScanner.nextLine().split(" ");
            String lastName = personData[0];
            String firstName = personData[1];
            String middleName = personData[2];
            String date = personData[3] + " " + personData[4] + " " + personData[5];
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yy");
            Date birthDate = new Date();
            try {
                birthDate = simpleDateFormat.parse(date);
            } catch (ParseException e) {
            }
            Person person = new Person(firstName, middleName, lastName, birthDate);
            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
