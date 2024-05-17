package com.javarush.task.task27.task2712;

import java.util.ArrayList;
import java.util.List;

public class RandomOrderGeneratorTask implements Runnable {

    private List<Tablet> allTablets;
    private int orderInterval;

    public RandomOrderGeneratorTask(List<Tablet> allTablets, int orderInterval) {
        this.allTablets = allTablets;
        this.orderInterval = orderInterval;
    }

    @Override
    public void run() {
        int randomIndex = (int) (Math.random() * (allTablets.size() - 1));
        Tablet randomTablet = allTablets.get(randomIndex);
        while (!Thread.currentThread().isInterrupted()) {
            randomTablet.createTestOrder();
            try {
                wait(orderInterval);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
