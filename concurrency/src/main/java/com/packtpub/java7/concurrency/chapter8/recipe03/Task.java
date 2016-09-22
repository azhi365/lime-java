package com.packtpub.java7.concurrency.chapter8.recipe03;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;


public class Task implements Runnable {


    private int time;


    private Phaser phaser;


    public Task(int time, Phaser phaser) {
        this.time = time;
        this.phaser = phaser;
    }


    @Override
    public void run() {
        /*
		 * Arrive to the phaser
		 */
        phaser.arrive();
		/*
		 * Phase 1
		 */
        System.out.printf("%s: Entering phase 1.\n", Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s: Finishing phase 1.\n", Thread.currentThread().getName());
		/*
		 * End of Phase 1
		 */
        phaser.arriveAndAwaitAdvance();
		/*
		 * Phase 2
		 */
        System.out.printf("%s: Entering phase 2.\n", Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s: Finishing phase 2.\n", Thread.currentThread().getName());
		/*
		 * End of Phase 2
		 */
        phaser.arriveAndAwaitAdvance();
		/*
		 * Phase 3
		 */
        System.out.printf("%s: Entering phase 3.\n", Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s: Finishing phase 3.\n", Thread.currentThread().getName());
		/*
		 * End of Phase 3
		 */
        phaser.arriveAndDeregister();
    }
}
