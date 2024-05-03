package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {

    private static BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        String s = null;
        while (true) {
            s = console.readLine();
            break;
        }

        return s;
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        writeMessage("Меню: " + Dish.allDishesToString());

        List<Dish> order = new ArrayList<>();
        String menuTitle = null;

        label:
        while (true) {
            writeMessage("Выберите блюдо:");
            menuTitle = readString().toLowerCase();
            switch (menuTitle) {
                case "fish":
                    order.add(Dish.FISH);
                    break;
                case "steak":
                    order.add(Dish.STEAK);
                    break;
                case "soup":
                    order.add(Dish.SOUP);
                    break;
                case "juice":
                    order.add(Dish.JUICE);
                    break;
                case "water":
                    order.add(Dish.WATER);
                    break;
                case "exit":
                    break label;
                default:
                    writeMessage("Такого блюда нет в меню.");
                    break;
            }
        }

        return order;
    }
}