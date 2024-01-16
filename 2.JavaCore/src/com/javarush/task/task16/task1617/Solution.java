package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/


public class Solution {
    public static volatile int numSeconds = 3;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        Thread.sleep(3500);
        clock.interrupt();
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            int secondsRunning = 0;
            while (secondsRunning <= 3500) {
                try {
                    if (numSeconds >= 1) {
                        System.out.print(numSeconds + " ");
                        Thread.sleep(1000);
                        secondsRunning += 1000;
                        numSeconds--;
                    } else {
                        System.out.print("Марш!");
                        return;
                    }
                } catch (InterruptedException e) {
                    System.out.print("Прервано!");
                    return;
                }
            }
        }
    }
}
