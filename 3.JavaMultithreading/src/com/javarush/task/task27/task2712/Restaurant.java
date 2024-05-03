package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;

public class Restaurant {

    public static void main(String[] args) {
        Tablet t1 = new Tablet(1);
        t1.addObserver(new Cook("Gordon"));
        t1.createOrder();
        t1.createOrder();
        t1.createOrder();
        t1.createOrder();
    }

}
