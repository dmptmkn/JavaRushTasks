package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.NoAvailableVideoEventDataRow;

public class Advertisement {

    public Object content;
    public String name;

    private long initialAmount;
    private int hits;
    private int duration;
    private long amountPerOneDisplaying;


    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        amountPerOneDisplaying = hits > 0 ? initialAmount / hits : 0;
    }

    public void revalidate() {
        if (hits <= 0) {
            throw new NoVideoAvailableException();
        }
        else hits--;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }
    
    public boolean isActive() {
        return hits > 0;
    }
}
