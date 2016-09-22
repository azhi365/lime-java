package com.packtpub.java7.concurrency.chapter7.core;

import com.packtpub.java7.concurrency.chapter7.recipe08.Task;

import java.util.concurrent.ForkJoinPool;

/**
 * 自定义在 Fork/Join 框架中运行的任务
 */
public class Chapter7Recipe8 {


    public static void main(String[] args) throws Exception {


        int array[] = new int[10000];

        ForkJoinPool pool = new ForkJoinPool();

        Task task = new Task("Task", array, 0, array.length);

        pool.invoke(task);

        pool.shutdown();

        System.out.printf("Main: End of the program.\n");

    }

}
