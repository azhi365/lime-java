package org.walnuts.study.concurrency.chapter3.core;

import org.walnuts.study.concurrency.chapter3.recipe3.Job;
import org.walnuts.study.concurrency.chapter3.recipe3.PrintQueue;

/**
 * 控制并发访问多个资源 Semaphore
 */
public class Chapter1Recipe3 {


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

}
