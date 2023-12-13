package com.javarush.task.task12.task1224;

/* 
Неведома зверушка
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cat()));
        System.out.println(getObjectType(new Tiger()));
        System.out.println(getObjectType(new Lion()));
        System.out.println(getObjectType(new Bull()));
        System.out.println(getObjectType(new Pig()));
    }

    public static String getObjectType(Object o) {
        String objectType = "Животное";

        if (o instanceof Cat) {
            objectType = "Кот";
        } else if (o instanceof Tiger) {
            objectType = "Тигр";
        } else if (o instanceof Lion) {
            objectType = "Лев";
        } else if (o instanceof Bull) {
            objectType = "Бык";
        }

        return objectType;
    }

    public static class Cat {
    }

    public static class Tiger {
    }

    public static class Lion {
    }

    public static class Bull {
    }

    public static class Pig {
    }
}
