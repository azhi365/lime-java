package concurrency.threadmanage;

import java.util.Date;
import java.util.concurrent.TimeUnit;


/**
 * 使用本地线程变量
 */
public class SafeThreadLocal {

    public static void main(String[] args) {
        SafeTask task = new SafeTask();
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(task);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            thread.start();
        }

    }


    public static class SafeTask implements Runnable {

        private static ThreadLocal<Date> startDate = new ThreadLocal<Date>() {
            protected Date initialValue() {
                return new Date();
            }
        };


        @Override
        public void run() {

            System.out.printf("Starting Thread: %s : %s\n", Thread.currentThread().getId(), startDate.get());
            try {
                TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("Thread Finished: %s : %s\n", Thread.currentThread().getId(), startDate.get());
        }

    }
}
