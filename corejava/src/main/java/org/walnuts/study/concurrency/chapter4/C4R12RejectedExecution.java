package org.walnuts.study.concurrency.chapter4;

import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * 执行者控制被拒绝的任务
 */
public class C4R12RejectedExecution {


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

    /**
     *
     */
    public static class Task implements Runnable {

        private String name;

        public Task(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.printf("Task %s: Starting\n", name);
            try {
                Long duration = (long) (Math.random() * 10);
                System.out.printf("Task %s: ReportGenerator: Generating a report during %d seconds\n", name, duration);
                TimeUnit.SECONDS.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("Task %s: Ending\n", name);
        }

        public String toString() {
            return name;
        }

    }


}
