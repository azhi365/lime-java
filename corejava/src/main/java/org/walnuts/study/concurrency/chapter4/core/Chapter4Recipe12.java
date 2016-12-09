package org.walnuts.study.concurrency.chapter4.core;

import org.walnuts.study.concurrency.chapter4.recipe12.Task;

import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;


/**
 * 执行者控制被拒绝的任务
 */
public class Chapter4Recipe12 {


    public static void main(String[] args) {


        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        executor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.printf("RejectedTaskController: The task %s has been rejected\n", r.toString());
                System.out.printf("RejectedTaskController: %s\n", executor.toString());
                System.out.printf("RejectedTaskController: Terminating: %s\n", executor.isTerminating());
                System.out.printf("RejectedTaksController: Terminated: %s\n", executor.isTerminated());
            }
        });

        System.out.printf("Main: Starting.\n");
        for (int i = 0; i < 3; i++) {
            Task task = new Task("Task" + i);
            executor.submit(task);
        }

        System.out.printf("Main: Shuting down the Executor.\n");
        executor.shutdown();//执行者结束

        System.out.printf("Main: Sending another Task.\n");
        Task task = new Task("RejectedTask");
        executor.submit(task);

        System.out.printf("Main: End.\n");

    }

}
