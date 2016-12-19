package org.walnuts.study.concurrency.chapter4;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <pre>
 * 创建一个线程执行者:
 * 你已创建的缓存线程池，当需要执行新的任务会创建新的线程，如果它们已经完成运行任务，变成可用状态，会重新使用这些线程。线程重复利用的好处是，它减少线程创建的时间。
 * 缓存线程池的缺点是，为新任务不断创建线程， 所以如果你提交过多的任务给执行者，会使系统超载。
 * 注意事项：使用通过newCachedThreadPool()方法创建的执行者，只有当你有一个合理的线程数或任务有一个很短的执行时间。
 * </pre>
 */
public class C4R2CachedThreadPool {


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
            executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        }


        public void executeTask(Task task) {
            System.out.printf("Server: A new task has arrived\n");
            executor.execute(task);
            System.out.printf("Server: Pool Size: %d\n", executor.getPoolSize());
            System.out.printf("Server: Active Count: %d\n", executor.getActiveCount());
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

            System.out.printf("%s: Task %s: Finished on: %s\n", Thread.currentThread().getName(), name, new Date());
        }

    }

}
