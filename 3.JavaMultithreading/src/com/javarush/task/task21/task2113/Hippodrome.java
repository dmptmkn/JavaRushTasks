package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Hippodrome {

    static Hippodrome game;

    private List<Horse> horses;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (Exception e) {
            }
        }
    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        return horses.stream().max(Comparator.comparingDouble(h -> h.getDistance())).get();
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) {
        List<Horse> horseList = new ArrayList<>();
        Horse horse1 = new Horse("Homer", 3F, 0F);
        Horse horse2 = new Horse("Lucky", 3F, 0F);
        Horse horse3 = new Horse("Slevin", 3F, 0F);
        horseList.add(horse1);
        horseList.add(horse2);
        horseList.add(horse3);
        Hippodrome hippodrome = new Hippodrome(horseList);
        game = hippodrome;
        game.run();
        game.printWinner();
    }

    public List<Horse> getHorses() {
        return horses;
    }
}
