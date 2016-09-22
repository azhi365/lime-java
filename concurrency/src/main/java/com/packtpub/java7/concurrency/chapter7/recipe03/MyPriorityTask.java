package com.packtpub.java7.concurrency.chapter7.recipe03;

import java.util.concurrent.TimeUnit;

/**
 * This is the base class to implement a priority-based executor. It implements the base for the priority tasks.
 * They are based on the Runnable interface and implement the Comparable interface.
 * If a task has a higher value of its priority attribute, it will be stored before in the priority queue and
 * it will be executed before
 */
public class MyPriorityTask implements Runnable, Comparable<MyPriorityTask> {


    private int priority;


    private String name;


    public MyPriorityTask(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }


    public int getPriority() {
        return priority;
    }


    @Override
    public int compareTo(MyPriorityTask o) {
        if (this.getPriority() < o.getPriority()) {
            return 1;
        }

        if (this.getPriority() > o.getPriority()) {
            return -1;
        }

        return 0;
    }


    @Override
    public void run() {
        System.out.printf("MyPriorityTask: %s Priority : %d\n", name, priority);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
