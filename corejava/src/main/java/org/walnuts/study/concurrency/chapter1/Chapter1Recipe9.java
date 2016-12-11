package org.walnuts.study.concurrency.chapter1;

/**
 * 处理线程的不受控制异常
 */
public class Chapter1Recipe9 {

    /**
     * Main method of the example. Initialize a Thread to process the
     * uncaught exceptions and starts a Task object that always throws an
     * exception
     *
     * @param args
     */
    public static void main(String[] args) {
        Task task = new Task();
        Thread thread = new Thread(task);
        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Thread has finished\n");

    }

    public static class Task implements Runnable {
        @Override
        public void run() {
            int numero = Integer.parseInt("TTT");
        }

    }


    public static class ExceptionHandler implements Thread.UncaughtExceptionHandler {

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.printf("An exception has been captured\n");
            System.out.printf("Thread: %s\n", t.getId());
            System.out.printf("Exception: %s: %s\n", e.getClass().getName(), e.getMessage());
            System.out.printf("Stack Trace: \n");
            e.printStackTrace(System.out);
            System.out.printf("Thread status: %s\n", t.getState());
        }

    }

}
