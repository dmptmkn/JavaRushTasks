package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class StatisticManager {

    private static StatisticManager instance;
    private StatisticStorage statisticStorage;

    private StatisticManager() {
        this.statisticStorage = new StatisticStorage();
    }

    public static StatisticManager getInstance() {
        if (instance == null) {
            instance = new StatisticManager();
        }

        return instance;
    }

    public Map<String, Long> getDailyAdIncomeMap() {
        List<EventDataRow> adDataRows = statisticStorage.get(EventType.SELECTED_VIDEOS);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Map<String, Long> dailyAdIncomeMap = adDataRows.stream()
                .map(eventDataRow -> (VideoSelectedEventDataRow) eventDataRow)
                .collect(Collectors.toMap(
                        eventDataRow -> dateFormat.format(eventDataRow.getDate()),
                        VideoSelectedEventDataRow::getAmount,
                        Long::sum));

        long sum = dailyAdIncomeMap.values().stream().mapToLong(Long::longValue).sum();
        dailyAdIncomeMap.put("Total", sum);

        return dailyAdIncomeMap;
    }

    public Map<String, Map<String, Integer>> getDailyCookWorkloadMap() {
        List<EventDataRow> cookDataRows = statisticStorage.get(EventType.COOKED_ORDER);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Map<String, Map<String, Integer>> dailyCookWorkloadMap = new HashMap<>();

        for (EventDataRow eventDataRow : cookDataRows) {
            CookedOrderEventDataRow orderDataRow = (CookedOrderEventDataRow) eventDataRow;

            String date = dateFormat.format(orderDataRow.getDate());
            if (!dailyCookWorkloadMap.containsKey(date)) {
                dailyCookWorkloadMap.put(date, new HashMap<String, Integer>());
            }

            Map<String, Integer> cookWorkload = dailyCookWorkloadMap.get(date);

            String cookName = orderDataRow.getCookName();
            if (!cookWorkload.containsKey(cookName)) {
                cookWorkload.put(cookName, 0);
            }

            Integer totalTime = cookWorkload.get(cookName);
            cookWorkload.put(cookName, totalTime + orderDataRow.getTime());
        }

        return dailyCookWorkloadMap;
    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }


    private class StatisticStorage {
        Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        public StatisticStorage() {
            for (EventType eventType : EventType.values()) {
                storage.put(eventType, new ArrayList<>());
            }
        }

        private void put(EventDataRow data) {
            List<EventDataRow> storageRow = storage.get(data.getType());
            storageRow.add(data);
            storage.put(data.getType(), storageRow);
        }

        private List<EventDataRow> get(EventType eventType) {
            if (!storage.containsKey(eventType)) throw new UnsupportedOperationException();

            return storage.get(eventType);
        }
    }
}
