package com.javarush.task.task27.task2712.kitchen;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Dish {
    FISH(25),
    STEAK(30),
    SOUP(15),
    JUICE(5),
    WATER(3);

    private int duration;

    Dish(int duration) {
        this.duration = duration;
    }

    public static String allDishesToString() {
        return Arrays.stream(values())
                .map(Enum::toString)
                .collect(Collectors.joining(", "));
    }

    public int getDuration() {
        return duration;
    }
}
