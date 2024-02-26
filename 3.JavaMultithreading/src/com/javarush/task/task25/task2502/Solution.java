package com.javarush.task.task25.task2502;

import java.util.*;

/* 
Машину на СТО не повезем!
*/

public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            wheels = new LinkedList<>();
            String[] myWheels = loadWheelNamesFromDB();
            if (myWheels.length != 4 || myWheels == null) throw new IllegalArgumentException();
            for (String wheel : myWheels) {
                try {
                    wheels.add(Wheel.valueOf(wheel));
                } catch (IllegalArgumentException e) {
                    throw e;
                }
            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
    }
}
