package org.walnuts.study.concurrency.chapter3;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 控制并发访问多个资源 Semaphore
 */
public class Chapter3Recipe3 {


    public static void main(String args[]) {

        PrintQueue printQueue = new PrintQueue();

        Thread thread[] = new Thread[12];
        for (int i = 0; i < 12; i++) {
            thread[i] = new Thread(new Job(printQueue), "Thread " + i);
        }

        for (int i = 0; i < 12; i++) {
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


        private Semaphore semaphore;


        private boolean freePrinters[];


        private Lock lock;


        public PrintQueue() {
            semaphore = new Semaphore(3);
            freePrinters = new boolean[3];
            for (int i = 0; i < 3; i++) {
                freePrinters[i] = true;
            }
            lock = new ReentrantLock();
        }

        public void printJob(Object document) {
            try {

                semaphore.acquire();

                int assignedPrinter = getPrinter();

                Long duration = (long) (Math.random() * 10);
                System.out.printf("%s: PrintQueue: Printing a Job in Printer %d during %d seconds\n", Thread.currentThread().getName(), assignedPrinter, duration);
                TimeUnit.SECONDS.sleep(duration);

                freePrinters[assignedPrinter] = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }

        private int getPrinter() {
            int rs = -1;

            try {
                lock.lock();
                for (int i = 0; i < freePrinters.length; i++) {
                    if (freePrinters[i]) {
                        rs = i;
                        freePrinters[i] = false;
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            return rs;
        }

    }

}
