package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;

public class Cook extends Observable {

    public String name;

    public Cook(String name) {
        this.name = name;
    }

    public void startCookingOrder(Order order) {
        ConsoleHelper.writeMessage("Start cooking - " + order.toString());
        setChanged();
        notifyObservers(order);
        CookedOrderEventDataRow dataRow = new CookedOrderEventDataRow(
                order.getTablet().toString(),
                this.name,
                order.getTotalCookingTime() * 60,
                order.getDishes());
        StatisticManager.getInstance().register(dataRow);
    }

    @Override
    public String toString() {
        return name;
    }
}
