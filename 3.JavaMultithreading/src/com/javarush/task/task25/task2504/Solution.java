package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/

public class Solution {
    public static void processThreads(Thread... threads) {
        for (Thread t : threads) {
            switch (t.getState()) {
                case NEW:
                    t.start();
                    break;
                case TIMED_WAITING:
                case WAITING:
                case BLOCKED:
                    t.interrupt();
                    break;
                case RUNNABLE:
                    t.isInterrupted();
                    break;
                case TERMINATED:
                    System.out.println(t.getPriority());
                    break;
            }
        }
    }

    public static void main(String[] args) {
    }
}
