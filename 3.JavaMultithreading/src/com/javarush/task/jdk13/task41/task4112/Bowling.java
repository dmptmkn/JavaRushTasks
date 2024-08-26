package com.javarush.task.jdk13.task41.task4112;

import java.util.HashSet;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class Bowling {

    private final Queue<Track> tracks = new LinkedBlockingQueue<>();
    private final Queue<PairOfShoes> shoes = new LinkedBlockingQueue<>();

    public Bowling(int tracksNumber) {
        for (int i = 1; i <= tracksNumber; i ++) {
            tracks.add(new Track(1));
        }

        Random random = new Random();
        for (int i = 1; i <= 50; i++) {
            shoes.add(new PairOfShoes(random.nextInt(38, 45)));
        }
    }

    public synchronized Track acquireTrack() {
        if (tracks.isEmpty()) return null;

        Track track = tracks.poll();
        track.setPrice(100 - tracks.size());
        return track;
    }

    public synchronized void releaseTrack(Track track) {
        System.out.printf("C дорожки №%d сняли бронь\n", track.getNumber());
        tracks.offer(track);
    }

    public synchronized Set<PairOfShoes> acquireShoes(int number) {
        if (shoes.isEmpty()) return null;

        Set<PairOfShoes> shoes = new HashSet<>();
        for (int i = 0; i < number; i++) {
            shoes.add(this.shoes.poll());
        }
        return shoes;
    }

    public synchronized void releaseShoes(Set<PairOfShoes> shoes) {
        System.out.printf("В гардероб вернули %d пар обуви\n", shoes.size());
        for (PairOfShoes pair : shoes) {
            this.shoes.add(pair);
        }
    }
}
