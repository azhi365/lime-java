package com.packtpub.java7.concurrency.chapter2.recipe5;

/**
 * This class simulates a job that send a document to print.
 */
public class Job implements Runnable {


    private PrintQueue printQueue;


    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        System.out.printf("%s: Going to print a document\n", Thread.currentThread().getName());
        printQueue.printJob(new Object());
        System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
    }
}
