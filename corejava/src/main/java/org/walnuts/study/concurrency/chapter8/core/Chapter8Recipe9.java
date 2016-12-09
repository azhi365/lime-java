package org.walnuts.study.concurrency.chapter8.core;

import org.walnuts.study.concurrency.chapter8.recipe09.Task1;
import org.walnuts.study.concurrency.chapter8.recipe09.Task2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 死锁示例
 */
public class Chapter8Recipe9 {


    public static void main(String args[]) throws Exception{

        Lock lock1, lock2;
        lock1=new ReentrantLock();
        lock2=new ReentrantLock();
        

        Task1 task1=new Task1(lock1, lock2);
        Task2 task2=new Task2(lock1, lock2);

        Thread thread1=new Thread(task1);
        Thread thread2=new Thread(task2);
        
        thread1.start();
        thread2.start();
        
        thread1.join();
        thread2.join();
        /*
         * While the tasks haven't finished, write a message every 500 milliseconds
         */
        /*while ((thread1.isAlive()) &&(thread2.isAlive())) {
            System.out.println("Core: The example is running");
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException ex) {
              ex.printStackTrace();
            }
        }*/
    }
}
