package com.javarush.task.task16.task1603;

import java.util.ArrayList;
import java.util.List;

/* 
Список и нити
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        SpecialThread thread1 = new SpecialThread();
        SpecialThread thread2 = new SpecialThread();
        SpecialThread thread3 = new SpecialThread();
        SpecialThread thread4 = new SpecialThread();
        SpecialThread thread5 = new SpecialThread();
        Thread threadOne = new Thread(thread1);
        Thread threadTwo = new Thread(thread2);
        Thread threadThree = new Thread(thread3);
        Thread threadFour = new Thread(thread4);
        Thread threadFive = new Thread(thread5);
        list.add(threadOne);
        list.add(threadTwo);
        list.add(threadThree);
        list.add(threadFour);
        list.add(threadFive);
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}
