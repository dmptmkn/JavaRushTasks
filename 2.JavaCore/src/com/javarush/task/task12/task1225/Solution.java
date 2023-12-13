package com.javarush.task.task12.task1225;

/* 
Посетители
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cat()));
        System.out.println(getObjectType(new Tiger()));
        System.out.println(getObjectType(new Lion()));
        System.out.println(getObjectType(new Bull()));
        System.out.println(getObjectType(new Cow()));
        System.out.println(getObjectType(new Animal()));
    }

    public static String getObjectType(Object o) {
        String objectType = "Животное";

        if (o instanceof Cat && !(o instanceof Lion) && !(o instanceof Tiger)) {
            objectType = "Кот";
        } else if (o instanceof Tiger) {
            objectType = "Тигр";
        } else if (o instanceof Lion) {
            objectType = "Лев";
        } else if (o instanceof Bull) {
            objectType = "Бык";
        } else if (o instanceof Cow) {
            objectType = "Корова";
        }

        return objectType;
    }

    public static class Cat extends Animal   //<--Классы наследуются!!
    {
    }

    public static class Tiger extends Cat {
    }

    public static class Lion extends Cat {
    }

    public static class Bull extends Animal {
    }

    public static class Cow extends Animal {
    }

    public static class Animal {
    }
}
