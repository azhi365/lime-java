package org.walnuts.study.concurrency.chapter5.core;

import org.walnuts.study.concurrency.chapter5.recipe03.task.DocumentTask;
import org.walnuts.study.concurrency.chapter5.recipe03.utils.DocumentMock;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * 加入任务的结果
 */
public class Chapter5Recipe3 {


    public static void main(String[] args) {

        DocumentMock mock = new DocumentMock();
        String[][] document = mock.generateDocument(100, 1000, "the");

        long begin =  System.currentTimeMillis();
        int count =0;
        for (String[] strings : document) {
            for (String string : strings) {
                if(string.equals("the")){
                    count++;
                }
            }
        }
        long mid = System.currentTimeMillis();


        DocumentTask task = new DocumentTask(document, 0, 100, "the");

        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(task);
        do {
            System.out.printf("******************************************\n");
            System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
            System.out.printf("Main: Active Threads: %d\n", pool.getActiveThreadCount());
            System.out.printf("Main: Task Count: %d\n", pool.getQueuedTaskCount());
            System.out.printf("Main: Steal Count: %d\n", pool.getStealCount());
            System.out.printf("******************************************\n");

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } while (!task.isDone());

        pool.shutdown();

        try {
            pool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            System.out.printf("Main: The word appears %d in the document", task.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("");
        System.out.println("--------------------");
        System.out.println(mid -begin);
        System.out.println(end -mid);
    }

}
