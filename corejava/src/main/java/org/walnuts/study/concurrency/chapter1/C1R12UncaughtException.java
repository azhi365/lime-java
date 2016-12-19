package org.walnuts.study.concurrency.chapter1;

import java.util.Random;

/**
 * 处理线程组内的不受控制异常
 */
public class C1R12UncaughtException {

    public static void main(String[] args) {

        MyThreadGroup threadGroup = new MyThreadGroup("MyThreadGroup");
        Task task = new Task();
        for (int i = 0; i < 2; i++) {
            Thread t = new Thread(threadGroup, task);
            t.start();
        }
    }

    public static class MyThreadGroup extends ThreadGroup {

        public MyThreadGroup(String name) {
            super(name);
        }

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.printf("The thread %s has thrown an Exception\n", t.getId());
            e.printStackTrace(System.out);
            System.out.printf("Terminating the rest of the Threads\n");
            interrupt();
        }
    }


    public static class Task implements Runnable {

        @Override
        public void run() {
            int result;
            Random random = new Random(Thread.currentThread().getId());
            while (true) {
                result = 1000 / ((int) (random.nextDouble() * 1000));
                System.out.printf("%s : %f\n", Thread.currentThread().getId(), result);
                if (Thread.currentThread().isInterrupted()) {
                    System.out.printf("%d : Interrupted\n", Thread.currentThread().getId());
                    return;
                }
            }
        }
    }

}
