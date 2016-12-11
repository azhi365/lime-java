package org.walnuts.study.concurrency.chapter1;

import java.util.Date;
import java.util.concurrent.TimeUnit;


/**
 * 使用本地线程变量
 */
public class Chapter1Recipe10UnSafe {

    public static void main(String[] args) {
        UnsafeTask task = new UnsafeTask();

        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(task);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class UnsafeTask implements Runnable {


        private Date startDate;

        @Override
        public void run() {
            startDate = new Date();
            System.out.printf("Starting Thread: %s : %s\n", Thread.currentThread().getId(), startDate);
            try {
                TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("Thread Finished: %s : %s\n", Thread.currentThread().getId(), startDate);
        }

    }
}
