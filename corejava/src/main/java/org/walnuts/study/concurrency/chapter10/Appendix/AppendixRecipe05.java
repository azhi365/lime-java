package org.walnuts.study.concurrency.chapter10.Appendix;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AppendixRecipe05 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Task1 task1 = new Task1(lock);
        Task2 task2 = new Task2(lock);
        Thread threads[] = new Thread[10];

        Date begin, end;

        begin = new Date();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(task1);
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        end = new Date();
        System.out.printf("Main: First Approach: %d\n", (end.getTime() - begin.getTime()));

        begin = new Date();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(task2);
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        end = new Date();
        System.out.printf("Main: Second Approach: %d\n", (end.getTime() - begin.getTime()));


    }

    public static class Task1 implements Runnable {

        private Lock lock;

        public Task1(Lock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            lock.lock();
            Operations.readData();
            Operations.processData();
            Operations.writeData();
            lock.unlock();
        }

    }

    public static class Task2 implements Runnable {

        private Lock lock;

        public Task2(Lock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            lock.lock();
            Operations.readData();
            lock.unlock();
            Operations.processData();
            lock.lock();
            Operations.writeData();
            lock.unlock();
        }
    }


    public static class Operations {

        public static void readData() {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public static void writeData() {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public static void processData() {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
