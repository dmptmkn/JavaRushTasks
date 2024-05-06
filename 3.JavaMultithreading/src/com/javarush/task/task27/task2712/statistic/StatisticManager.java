package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;

import java.util.*;

public class StatisticManager {

    private static StatisticManager instance;
    private StatisticStorage statisticStorage;
    private Set<Cook> cooks;

    private StatisticManager() {
        this.statisticStorage = new StatisticStorage();
        this.cooks = new HashSet<>();
    }

    public static StatisticManager getInstance() {
        if (instance == null) {
            instance = new StatisticManager();
        }

        return instance;
    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

    public void register(Cook cook) {
        cooks.add(cook);
    }

    private class StatisticStorage {
        Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        public StatisticStorage() {
            for (EventType eventType : EventType.values()) {
                storage.put(eventType, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data) {
            List<EventDataRow> storageRow = storage.get(data.getType());
            storageRow.add(data);
            storage.put(data.getType(), storageRow);
        }
    }

}
