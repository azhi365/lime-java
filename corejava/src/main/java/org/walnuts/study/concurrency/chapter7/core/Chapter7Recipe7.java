package org.walnuts.study.concurrency.chapter7.core;

import org.walnuts.study.concurrency.chapter7.recipe07.MyRecursiveTask;
import org.walnuts.study.concurrency.chapter7.recipe07.MyWorkerThreadFactory;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * 实现ThreadFactory接口生成自定义的线程给Fork/Join框架
 */
public class Chapter7Recipe7 {

    public static void main(String[] args) throws Exception {

        MyWorkerThreadFactory factory = new MyWorkerThreadFactory();

        ForkJoinPool pool = new ForkJoinPool(4, factory, null, false);


        int array[] = new int[100000];

        for (int i = 0; i < array.length; i++) {
            array[i] = 1;
        }

        MyRecursiveTask task = new MyRecursiveTask(array, 0, array.length);

        pool.execute(task);

        task.join();

        pool.shutdown();

        pool.awaitTermination(1, TimeUnit.DAYS);


        System.out.printf("Main: Result: %d\n", task.get());
        System.out.printf("Main: End of the program\n");
    }

}
