package com.packtpub.java7.concurrency.chapter5.core;

import com.packtpub.java7.concurrency.chapter5.recipe02.task.Task;
import com.packtpub.java7.concurrency.chapter5.recipe02.util.Product;
import com.packtpub.java7.concurrency.chapter5.recipe02.util.ProductListGenerator;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * 创建一个Fork/Join池
 */
public class Chapter5Recipe2 {

    public static void main(String[] args) {

        ProductListGenerator generator = new ProductListGenerator();

        List<Product> products = generator.generate(10000);

        Task task = new Task(products, 0, products.size(), 0.20);

        ForkJoinPool pool = new ForkJoinPool();//
        pool.execute(task);

        do {
            System.out.printf("Main: Thread Count: %d\n", pool.getActiveThreadCount());//当前执行任务的线程的数量
            System.out.printf("Main: Thread Steal: %d\n", pool.getStealCount());//worker 线程已经从另一个线程偷取到的时间数
            System.out.printf("Main: Paralelism: %d\n", pool.getParallelism());//池的并行的级别
            try {
                TimeUnit.MILLISECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!task.isDone());

        pool.shutdown();

        if (task.isCompletedNormally()) {
            System.out.printf("Main: The process has completed normally.\n");
        }

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getPrice() != 12) {
                System.out.printf("Product %s: %f\n", product.getName(), product.getPrice());
            }
        }

        System.out.println("Main: End of the program.\n");

    }

}
