package org.walnuts.study.concurrency.chapter5.core;

import org.walnuts.study.concurrency.chapter5.recipe06.task.SearchNumberTask;
import org.walnuts.study.concurrency.chapter5.recipe06.util.ArrayGenerator;
import org.walnuts.study.concurrency.chapter5.recipe06.util.TaskManager;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * 取消任务
 */
public class Chapter5Recipe6 {


    public static void main(String[] args) {

        ArrayGenerator generator = new ArrayGenerator();
        int array[] = generator.generateArray(1000);

        TaskManager manager = new TaskManager();

        ForkJoinPool pool = new ForkJoinPool();

        SearchNumberTask task = new SearchNumberTask(array, 0, 1000, 5, manager);

        pool.execute(task);
        pool.shutdown();


        try {
            pool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Main: The program has finished\n");
    }

}
