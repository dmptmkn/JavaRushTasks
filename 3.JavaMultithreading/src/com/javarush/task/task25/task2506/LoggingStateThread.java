package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {

    private Thread targetThread;

    public LoggingStateThread(Thread target) {
        this.targetThread = target;
    }

    @Override
    public void run() {
        State firstState = targetThread.getState();
        System.out.println(firstState);
        while (targetThread.getState() != State.TERMINATED) {
            State secondState = targetThread.getState();
            if (secondState != firstState) {
                System.out.println(secondState);
                firstState = secondState;
            }
        }
        System.out.println(State.TERMINATED);
    }
}
