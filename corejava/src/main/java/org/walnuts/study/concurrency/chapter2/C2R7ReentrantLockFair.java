package org.walnuts.study.concurrency.chapter2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 修改Lock的公平性
 */
public class C2R7ReentrantLockFair {


    public static void main(String args[]) {
        PrintQueue printQueue = new PrintQueue();

        Thread thread[] = new Thread[10];
        for (int i = 0; i < 10; i++) {
            thread[i] = new Thread(new Job(printQueue), "Thread " + i);
        }

        for (int i = 0; i < 10; i++) {
            thread[i].start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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


        private final Lock queueLock = new ReentrantLock(true);


        public void printJob(Object document) {
            queueLock.lock();

            try {
                Long duration = (long) (Math.random() * 10000);
                System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n", Thread.currentThread().getName(), (duration / 1000));
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                queueLock.unlock();
            }


            queueLock.lock();
            try {
                Long duration = (long) (Math.random() * 10000);
                System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n", Thread.currentThread().getName(), (duration / 1000));
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                queueLock.unlock();
            }
        }
    }

}
