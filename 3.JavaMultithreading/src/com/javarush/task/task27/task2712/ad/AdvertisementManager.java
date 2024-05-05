package com.javarush.task.task27.task2712.ad;

import java.util.List;
import java.util.stream.Collectors;

public class AdvertisementManager {

    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() throws NoVideoAvailableException {
        List<Advertisement> adList = storage.list().stream()
                .filter(ad -> (ad.getDuration() / 60) <= timeSeconds)
                .collect(Collectors.toList());
        if (adList.isEmpty()) throw new NoVideoAvailableException();
    }
}
