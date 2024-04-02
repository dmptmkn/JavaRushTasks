package com.javarush.task.jdk13.task34.task3410;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/* 
Обнуление объекта
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        User user = new User(28219, "Paulo", 40, 9999, "paulo@javarush.com");
        System.out.println(user);
        reset(user);
        System.out.println(user);
    }

    public static void reset(Object object) throws Exception {
        Arrays.stream(object.getClass().getDeclaredFields())
                .filter(f -> Modifier.isPrivate(f.getModifiers()) &&
                        !Modifier.isStatic(f.getModifiers()) &&
                        !f.getType().isPrimitive())
                .peek(f -> f.setAccessible(true))
                .forEach(f -> {
                    try {
                        f.set(object, null);
                    } catch (IllegalAccessException e) {
                    }
                });
    }
}
