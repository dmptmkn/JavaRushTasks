package com.javarush.task.task27.task2712.statistic.event;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.util.Date;
import java.util.List;

public class CookedOrderEventDataRow implements EventDataRow {

    String tabletName;
    String cookName;
    int cookingTimeSeconds;
    List<Dish> cookingDishes;
    Date currentDate;

    public CookedOrderEventDataRow(String tableName, String cookName, int cookingTimeSeconds, List<Dish> cookingDishes) {
        this.tabletName = tableName;
        this.cookName = cookName;
        this.cookingTimeSeconds = cookingTimeSeconds;
        this.cookingDishes = cookingDishes;
        this.currentDate = new Date();
    }
}
