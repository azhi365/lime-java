package org.walnuts.study.concurrency.chapter4;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 创建一个大小固定的线程执行者:
 * <p>
 * 这个执行者有最大线程数。 如果你提交超过这个最大线程数的任务，这个执行者将不会创建额外的线程，并且剩下的任务将会阻塞，直到执行者有空闲线程。这种行为，保证执行者不会引发应用程序性能不佳的问题。
 */
public class C4R3FixedThreadPool {


    public static void main(String[] args) {
        Server server = new Server();

        for (int i = 0; i < 100; i++) {
            Task task = new Task("Task " + i);
            server.executeTask(task);
        }

        server.endServer();

    }

    public static class Server {


        private ThreadPoolExecutor executor;


        public Server() {
            executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        }


        public void executeTask(Task task) {
            System.out.printf("Server: A new task has arrived\n");
            executor.execute(task);
            System.out.printf("Server: Pool Size: %d\n", executor.getPoolSize());
            System.out.printf("Server: Active Count: %d\n", executor.getActiveCount());
            System.out.printf("Server: Task Count: %d\n", executor.getTaskCount());
            System.out.printf("Server: Completed Tasks: %d\n", executor.getCompletedTaskCount());
        }


        public void endServer() {
            executor.shutdown();
        }

    }

    public static class Task implements Runnable {

        private Date initDate;


        private String name;


        public Task(String name) {
            initDate = new Date();
            this.name = name;
        }


        @Override
        public void run() {
            System.out.printf("%s: Task %s: Created on: %s\n", Thread.currentThread().getName(), name, initDate);
            System.out.printf("%s: Task %s: Started on: %s\n", Thread.currentThread().getName(), name, new Date());

            try {
                Long duration = (long) (Math.random() * 10);
                System.out.printf("%s: Task %s: Doing a task during %d seconds\n", Thread.currentThread().getName(), name, duration);
                TimeUnit.SECONDS.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.printf("%s: Task %s: Finished on: %s\n", Thread.currentThread().getName(), new Date(), name);
        }

    }

}
