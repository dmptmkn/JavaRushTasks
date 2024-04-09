package com.javarush.task.task28.task2805;

public class MyThread extends Thread {

    public static int priority = MIN_PRIORITY;

    public MyThread() {
        setPriority(priority);
        if (priority == MAX_PRIORITY) {
            priority = MIN_PRIORITY;
        } else {
            priority++;
        }
    }

    public MyThread(Runnable target) {
        super(target);
        setPriority(priority);
        if (priority == MAX_PRIORITY) {
            priority = MIN_PRIORITY;
        } else {
            priority++;
        }
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        if (priority > group.getMaxPriority() && priority < MAX_PRIORITY) {
            setPriority(group.getMaxPriority());
            priority++;
        } else if (priority == MAX_PRIORITY) {
            setPriority(group.getMaxPriority());
            priority = MIN_PRIORITY;
        } else {
            setPriority(priority);
            priority++;
        }
    }

    public MyThread(String name) {
        super(name);
        setPriority(priority);
        if (priority == MAX_PRIORITY) {
            priority = MIN_PRIORITY;
        } else {
            priority++;
        }
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        if (priority > group.getMaxPriority() && priority < MAX_PRIORITY) {
            setPriority(group.getMaxPriority());
            priority++;
        } else if (priority == MAX_PRIORITY) {
            setPriority(group.getMaxPriority());
            priority = MIN_PRIORITY;
        } else {
            setPriority(priority);
            priority++;
        }
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        setPriority(priority);
        if (priority == MAX_PRIORITY) {
            priority = MIN_PRIORITY;
        } else {
            priority++;
        }
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        if (priority > group.getMaxPriority() && priority < MAX_PRIORITY) {
            setPriority(group.getMaxPriority());
            priority++;
        } else if (priority == MAX_PRIORITY) {
            setPriority(group.getMaxPriority());
            priority = MIN_PRIORITY;
        } else {
            setPriority(priority);
            priority++;
        }
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        if (priority > group.getMaxPriority() && priority < MAX_PRIORITY) {
            setPriority(group.getMaxPriority());
            priority++;
        } else if (priority == MAX_PRIORITY) {
            setPriority(group.getMaxPriority());
            priority = MIN_PRIORITY;
        } else {
            setPriority(priority);
            priority++;
        }
    }
}
