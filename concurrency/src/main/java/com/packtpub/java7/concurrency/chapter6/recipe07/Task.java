package com.packtpub.java7.concurrency.chapter6.recipe07;

import java.util.concurrent.ThreadLocalRandom;

public class Task implements Runnable {


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
