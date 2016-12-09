package org.walnuts.study.concurrency.chapter7.core;

import org.walnuts.study.concurrency.chapter7.recipe09.MyLock;
import org.walnuts.study.concurrency.chapter7.recipe09.Task;

import java.util.concurrent.TimeUnit;

/**
 * 实现一个自定义的Lock类
 */
public class Chapter7Recipe9 {


    public static void main(String[] args) {

        MyLock lock = new MyLock();

        for (int i = 0; i < 10; i++) {
            Task task = new Task("Task-" + i, lock);
            Thread thread = new Thread(task);
            thread.start();
        }

		/*
		 * The main thread also tries to get the lock
		 */
        boolean value;
        do {
            try {
                value = lock.tryLock(1, TimeUnit.SECONDS);
                if (!value) {
                    System.out.printf("Main: Trying to get the Lock\n");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                value = false;
            }
        } while (!value);
		

        System.out.printf("Main: Got the lock\n");
        lock.unlock();
		
        System.out.printf("Main: End of the program\n");
    }

}
