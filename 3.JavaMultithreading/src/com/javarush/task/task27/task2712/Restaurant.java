package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;

public class Restaurant {

    private static final int ORDER_CREATING_INTERVAL = 100;

    public static void main(String[] args) {
        Tablet t1 = new Tablet(1);
        Cook c1 = new Cook("Gordon");
        Waiter w1 = new Waiter();
        DirectorTablet dt1 = new DirectorTablet();

        t1.addObserver(c1);
        c1.addObserver(w1);

        t1.createOrder();
        dt1.printActiveVideoSet();
        dt1.printArchivedVideoSet();
        dt1.printCookWorkloading();
        dt1.printAdvertisementProfit();
    }

}
