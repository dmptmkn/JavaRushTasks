package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter writer = new PrintWriter(outputStream);

            if (users != null) {
                for (User user : users) {
                    writer.println(user.getFirstName() + " " + user.getLastName());
                    writer.flush();
                    writer.println(user.getBirthDate().getTime());
                    writer.flush();
                    if (user.isMale()) {
                        writer.println("male");
                        writer.flush();
                    } else {
                        writer.println("female");
                        writer.flush();
                    }
                    writer.println(user.getCountry().getDisplayName());
                    writer.flush();
                }
            }
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            if (users != null) {
                while (reader.ready()) {
                    String[] name = reader.readLine().split(" ");
                    String firstName = name[0];
                    String lastName = name[1];
                    long birthDate = Long.parseLong(reader.readLine());
                    boolean isMale = reader.readLine().equals("male");
                    String countryName = reader.readLine();
                    User aUser = new User();
                    aUser.setFirstName(firstName);
                    aUser.setLastName(lastName);
                    aUser.setBirthDate(new Date(birthDate));
                    aUser.setMale(isMale);
                    if (countryName.equals("Ukraine")) {
                        aUser.setCountry(User.Country.UKRAINE);
                    } else if (countryName.equals("Russia")) {
                        aUser.setCountry(User.Country.RUSSIA);
                    } else {
                        aUser.setCountry(User.Country.OTHER);
                    }
                    users.add(aUser);
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
