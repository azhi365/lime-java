package org.walnuts.study.concurrency.chapter1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 线程的睡眠和恢复
 * <p/>
 * 当 Thread is是睡眠和中断的时候，那方法会立刻抛出InterruptedException异常并不会一直等到睡眠时间过去。
 */
public class Chapter1Recipe6 {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Thread thread = new Thread(new FileClock());
        thread.start();

        try {
            // Waits five seconds
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ;
        // Interrupts the Thread
        thread.interrupt();
    }

    /**
     * Class that writes the actual date to a file every second
     */
    public static class FileClock implements Runnable {

        /**
         * Main method of the class
         */
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.printf("%s\n", new Date());
                try {
                    // Sleep during one second
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    System.out.printf("The FileClock has been interrupted");
                }
            }
        }
    }

}
