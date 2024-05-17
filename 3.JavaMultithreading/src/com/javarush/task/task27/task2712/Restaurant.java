package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private static final int ORDER_CREATING_INTERVAL = 100;

    public static void main(String[] args) {
        List<Tablet> tablets = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            tablets.add(new Tablet(i + 1));
        }

        Cook c1 = new Cook("Gordon");
        Cook c2 = new Cook("Heston");

        StatisticManager statisticManager = StatisticManager.getInstance();
        statisticManager.register(c1);
        statisticManager.register(c2);

        for (Tablet tablet : tablets) {
            tablet.addObserver(c1);
            tablet.addObserver(c2);
        }

        Thread thread = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
        thread.start();

        try {
            Thread.sleep(1000);
            thread.interrupt();
            thread.join();
            Thread.sleep(1000);
        } catch (InterruptedException ignore) {
        }

        DirectorTablet dt1 = new DirectorTablet();
        dt1.printActiveVideoSet();
        dt1.printArchivedVideoSet();
        dt1.printCookWorkloading();
        dt1.printAdvertisementProfit();
    }

}
