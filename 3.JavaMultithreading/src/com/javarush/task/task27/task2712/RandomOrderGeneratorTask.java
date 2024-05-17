package com.javarush.task.task27.task2712;

import java.util.List;

public class RandomOrderGeneratorTask implements Runnable {

    private List<Tablet> tablets;
    private int interval;

    public RandomOrderGeneratorTask(List<Tablet> allTablets, int orderInterval) {
        this.tablets = allTablets;
        this.interval = orderInterval;
    }

    @Override
    public void run() {
        int randomIndex = (int) (Math.random() * (tablets.size() - 1));
        Tablet randomTablet = tablets.get(randomIndex);

        while (!Thread.currentThread().isInterrupted()) {
            randomTablet.createTestOrder();
            try {
                wait(interval);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
