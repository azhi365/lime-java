package org.walnuts.study.concurrency.chapter6;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 创建并发随机数 ThreadLocalRandom
 */
public class Chapter6Recipe7 {


    public static void main(String[] args) {

        Thread threads[] = new Thread[3];

        for (int i = 0; i < threads.length; i++) {
            new Thread(new Task()).start();
        }

    }

    public static class Task implements Runnable {


        public Task() {
            ThreadLocalRandom.current();
        }


        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            for (int i = 0; i < 10; i++) {
                System.out.printf("%s: %d\n", name, ThreadLocalRandom.current().nextInt(10));
            }
        }

    }

}
