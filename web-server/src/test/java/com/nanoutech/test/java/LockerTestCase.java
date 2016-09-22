package com.nanoutech.test.java;

import com.nanoutech.test.java.lock.Locker;
import com.nanoutech.test.java.lock.ReadWriteLocker;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Lockers 在多线程编程里面一个重要的概念是锁定，如果一个资源是多个线程共享的，为了保证数据的完整性，
 * 在进行事务性操作时需要将共享资源锁定，这样可以保证在做事务性操作时只有一个线程能对资源进行操作，
 * 从而保证数据的完整性。在5.0以前，锁定的功能是由Synchronized关键字来实现的。
 */
public class LockerTestCase {

    public void testLock() throws Exception {
        final Locker locker = new Locker();
        // 新建任务1，调用lockTest的addValue方法
        Runnable task1 = new Runnable() {
            public void run() {
                locker.addValue(55.55);
            }
        };
        // 新建任务2，调用lockTest的getValue方法
        Runnable task2 = new Runnable() {
            public void run() {
                System.out.println("value: " + locker.getValue());
            }
        };
        // 新建任务执行服务
        ExecutorService cachedService = Executors.newCachedThreadPool();
        Future<?> future = null;
        // 同时执行任务1三次，由于addValue方法使用了锁机制，所以，实质上会顺序执行
        for (int i = 0; i < 3; i++) {
            future = cachedService.submit(task1);
        }
        // 等待最后一个任务1被执行完
        future.get();
        // 再执行任务2，输出结果
        future = cachedService.submit(task2);
        // 等待任务2执行完后，关闭任务执行服务
        future.get();
        cachedService.shutdownNow();
        System.out.println("-----------------------------------");
    }

    @Test
    public void testReadWriteLock() throws Exception {
        final ReadWriteLocker readWriteLockTest = new ReadWriteLocker();
        // 新建任务1，调用lockTest的addValue方法
        Runnable task_1 = new Runnable() {
            public void run() {
                readWriteLockTest.addValue(55.55);
            }
        };
        // 新建任务2，调用lockTest的getValue方法
        Runnable task_2 = new Runnable() {
            public void run() {
                System.out.println("info: " + readWriteLockTest.getInfo());
            }
        };
        // 新建任务执行服务
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<?> future_1 = null;
        // 同时执行5个任务，其中前2个任务是task_1，后两个任务是task_2
        for (int i = 0; i < 2; i++) {
            future_1 = executorService.submit(task_1);
        }
        for (int i = 0; i < 2; i++) {
            future_1 = executorService.submit(task_2);
        }
        // 最后一个任务是task_1
        future_1 = executorService.submit(task_1);
        // 这5个任务的执行顺序应该是：
        // 第一个task_1先执行，第二个task_1再执行；这是因为不能同时写，所以必须等。
        // 然后2个task_2同时执行；这是因为在写的时候，就不能读，所以都等待写结束，
        // 又因为可以同时读，所以它们同时执行
        // 最后一个task_1再执行。这是因为在读的时候，也不能写，所以必须等待读结束后，才能写。

        // 等待最后一个task_2被执行完
        future_1.get();
        executorService.shutdownNow();
    }

}