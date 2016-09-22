package com.packtpub.java7.concurrency.chapter7.core;

import com.packtpub.java7.concurrency.chapter7.recipe05.MyTask;
import com.packtpub.java7.concurrency.chapter7.recipe05.MyThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 在一个Executor对象中使用自定义的ThreadFactory
 */
public class Chapter7Recipe5 {


    public static void main(String[] args) throws Exception {


        MyThreadFactory threadFactory = new MyThreadFactory("MyThreadFactory");
        ExecutorService executor = Executors.newCachedThreadPool(threadFactory);
        MyTask task = new MyTask();

        executor.submit(task);
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);

        System.out.printf("Main: End of the program.\n");


    }

}
