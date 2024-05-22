package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {

    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> ORDER_QUEUE = new LinkedBlockingQueue<>(200);

    public static void main(String[] args) {
        List<Tablet> tablets = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            tablets.add(new Tablet(i + 1));
        }

        Cook gordon = new Cook("Gordon");
        gordon.setQueue(ORDER_QUEUE);
        Cook heston = new Cook("Heston");
        heston.setQueue(ORDER_QUEUE);

        for (Tablet tablet : tablets) {
            tablet.setQueue(ORDER_QUEUE);
        }

        Thread thread = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
        thread.start();

        Thread gordonThread = new Thread(gordon);
        gordonThread.setDaemon(true);
        gordonThread.start();

        Thread hestonThread = new Thread(heston);
        hestonThread.setDaemon(true);
        hestonThread.start();

        try {
            Thread.sleep(1000);
            thread.interrupt();
            thread.join();
            Thread.sleep(1000);
        } catch (InterruptedException ignore) {
        }

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
        directorTablet.printCookWorkloading();
        directorTablet.printAdvertisementProfit();
    }

}
