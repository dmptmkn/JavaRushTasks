package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable {

    private final int number;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }

    public Order createOrder() {
        Order newOrder = null;

        try {
            newOrder = new Order(this);
            ConsoleHelper.writeMessage(newOrder.toString());
            setChanged();
            if (!newOrder.isEmpty()) {
                notifyObservers(newOrder);
                AdvertisementManager newAdManager = new AdvertisementManager(newOrder.getTotalCookingTime() * 60);
                newAdManager.processVideos();
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }

        return newOrder;
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }
}
