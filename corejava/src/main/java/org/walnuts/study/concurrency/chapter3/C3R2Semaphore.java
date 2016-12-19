package org.walnuts.study.concurrency.chapter3;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 控制并发访问资源 Semaphore
 */
public class C3R2Semaphore {

    public static void main(String args[]) {

        PrintQueue printQueue = new PrintQueue();

        Thread thread[] = new Thread[10];
        for (int i = 0; i < 10; i++) {
            thread[i] = new Thread(new Job(printQueue), "Thread " + i);
        }

        for (int i = 0; i < 10; i++) {
            thread[i].start();
        }
    }

    public static class Job implements Runnable {

        private PrintQueue printQueue;

        public Job(PrintQueue printQueue) {
            this.printQueue = printQueue;
        }

        @Override
        public void run() {
            System.out.printf("%s: Going to print a job\n", Thread.currentThread().getName());
            printQueue.printJob(new Object());
            System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
        }
    }

    public static class PrintQueue {

        private final Semaphore semaphore;


        public PrintQueue() {
            semaphore = new Semaphore(1);
        }


        public void printJob(Object document) {
            try {

                semaphore.acquire();

                Long duration = (long) (Math.random() * 10);
                System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n", Thread.currentThread().getName(), duration);
                Thread.sleep(duration);
                TimeUnit.SECONDS.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }

    }


}
