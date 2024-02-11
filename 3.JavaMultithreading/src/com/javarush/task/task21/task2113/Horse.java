package com.javarush.task.task21.task2113;

import java.util.Arrays;

public class Horse {

    String name;
    double speed;
    double distance;

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void move() {
        distance += speed * Math.random();
    }

    public void print() {
        System.out.println(getDistanceString());
    }

    private String getDistanceString() {
        int length = (int) Math.floor(getDistance());
        StringBuilder distanceString = new StringBuilder("");
        for (int i = 0; i < length; i++) {
            distanceString.append(".");
        }
        distanceString.append(getName());
        return distanceString.toString();
    }
}
