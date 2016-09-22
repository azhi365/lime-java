package com.packtpub.java7.concurrency.chapter2.core;

import com.packtpub.java7.concurrency.chapter2.recipe7.Job;
import com.packtpub.java7.concurrency.chapter2.recipe7.PrintQueue;

/**
 * 修改Lock的公平性
 */
public class Chapter2Recipe7 {


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

}
