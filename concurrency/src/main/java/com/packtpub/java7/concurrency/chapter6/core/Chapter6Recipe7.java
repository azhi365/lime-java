package com.packtpub.java7.concurrency.chapter6.core;

import com.packtpub.java7.concurrency.chapter6.recipe07.Task;

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

}
