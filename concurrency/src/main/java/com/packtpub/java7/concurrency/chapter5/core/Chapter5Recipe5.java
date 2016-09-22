package com.packtpub.java7.concurrency.chapter5.core;

import com.packtpub.java7.concurrency.chapter5.recipe05.Task;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * 在任务中抛出异常
 */
public class Chapter5Recipe5 {


    public static void main(String[] args) {
        int array[] = new int[100];
        Task task = new Task(array, 0, 100);

        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(task);
        pool.shutdown();

        try {
            pool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        if (task.isCompletedAbnormally()) {
            System.out.printf("Main: An exception has ocurred\n");
            System.out.printf("Main: %s\n", task.getException());
        }

        System.out.printf("Main: Result: %d", task.join());
    }
}
