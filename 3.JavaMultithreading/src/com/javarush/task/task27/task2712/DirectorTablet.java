package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.*;

public class DirectorTablet {

    void printAdvertisementProfit() {
        StatisticManager statisticManager = StatisticManager.getInstance();

        Map<String, Long> dailyAdIncomeMap = statisticManager.getDailyAdIncomeMap();
        List<String> keys = new ArrayList<>(dailyAdIncomeMap.keySet());
        Collections.sort(keys);

        for (String key : keys) {
            double amount = 1.0 * dailyAdIncomeMap.get(key) / 100;
            System.out.println(key + " - " + String.format(Locale.ENGLISH, "%.2f", amount));
        }
    }

    void printCookWorkloading() {
        StatisticManager statisticManager = StatisticManager.getInstance();

        Map<String, Map<String, Integer>> dailyCookWorkloadMap = statisticManager.getDailyCookWorkloadMap();
        List<String> keys = new ArrayList<>(dailyCookWorkloadMap.keySet());
        Collections.sort(keys);

        for (String key : keys) {
            Map<String, Integer> cookMap = dailyCookWorkloadMap.get(key);
            System.out.println(key);

            List<String> cookNames = new ArrayList<>(cookMap.keySet());
            Collections.sort(cookNames);
            for (String cookName : cookNames) {
                System.out.println(cookName + " - " + ((cookMap.get(cookName) + 59) / 60) + " min");
            }
            System.out.println();
        }
    }

    void printActiveVideoSet() {
        StatisticAdvertisementManager statisticAdvertisementManager = StatisticAdvertisementManager.getInstance();

        List<Advertisement> activeAdList = statisticAdvertisementManager.getActiveAdList();
        activeAdList.stream()
                .sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))
                .forEach(ad -> System.out.println(ad.getName() + " - " + ad.getHits()));
    }

    void printArchivedVideoSet() {
        StatisticAdvertisementManager statisticAdvertisementManager = StatisticAdvertisementManager.getInstance();

        List<Advertisement> inactiveAdList = statisticAdvertisementManager.getInactiveAdList();
        inactiveAdList.stream()
                .sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))
                .forEach(ad -> System.out.println(ad.getName()));
    }
}
