package com.packtpub.java7.concurrency.chapter7.core;

import com.packtpub.java7.concurrency.chapter7.recipe06.MyScheduledThreadPoolExecutor;
import com.packtpub.java7.concurrency.chapter7.recipe06.Task;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 自定义在计划的线程池内运行的任务
 */
public class Chapter7Recipe6 {


    public static void main(String[] args) throws Exception {

        MyScheduledThreadPoolExecutor executor = new MyScheduledThreadPoolExecutor(2);

        Task task = new Task();
        System.out.printf("Main: %s\n", new Date());
        executor.schedule(task, 1, TimeUnit.SECONDS);

        TimeUnit.SECONDS.sleep(3);

        task = new Task();
        System.out.printf("Main: %s\n", new Date());
        executor.scheduleAtFixedRate(task, 1, 3, TimeUnit.SECONDS);

        TimeUnit.SECONDS.sleep(10);

        executor.shutdown();

        executor.awaitTermination(1, TimeUnit.DAYS);

        System.out.printf("Main: End of the program.\n");
    }

}
