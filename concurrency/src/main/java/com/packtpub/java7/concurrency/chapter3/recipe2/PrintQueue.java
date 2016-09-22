package com.packtpub.java7.concurrency.chapter3.recipe2;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class PrintQueue {

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
