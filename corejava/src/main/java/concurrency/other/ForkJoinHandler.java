package concurrency.other;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

public class ForkJoinHandler {


    public static void main(String[] args) {

        OneSecondLongTask task = new OneSecondLongTask();

        AlwaysThrowsExceptionWorkerThreadFactory factory = new AlwaysThrowsExceptionWorkerThreadFactory();
        // Creates a new ForkJoinPool
        ForkJoinPool pool = new ForkJoinPool(2, factory, new Handler(), false);

        // Execute the task in the pool
        pool.execute(task);

        // Shutdown the pool
        pool.shutdown();

        // Wait for the finalization of the tasks
        try {
            pool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Main: The program has finished.\n");

    }

    /**
     * This is the Task used in this example. It does nothing. Only
     * sleeps the thread during 1 second
     */
    public static class OneSecondLongTask extends RecursiveAction {

        /**
         * Serial Version UID
         */
        private static final long serialVersionUID = 1L;

        /**
         * Method that executes the action of the Task. It sleeps
         * the thread during one second
         */
        @Override
        protected void compute() {
            System.out.printf("Task: Starting.\n");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("Task: Finish.\n");
        }

    }


    /**
     * This class manages the exceptions thrown by the worker threads.
     * <p>
     * Implements the interface every class of this kind has to implement
     */
    public static class Handler implements Thread.UncaughtExceptionHandler {

        /**
         * This method process the uncaught exceptions thrown in a
         * worker thread.
         *
         * @param t The thread that throws the exception
         * @param e The exception it was thrown
         */
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.printf("Handler: Thread %s has thrown an Exception.\n", t.getName());
            System.out.printf("%s\n", e);
            System.exit(-1);
        }

    }


    /**
     * This class implements a worker thread. This is a thread that
     * is going to execute ForkJoinTask objects in a ForkJoinPool.
     * <p>
     * Extends the basic class ForkJoinWorkerThread
     */
    public static class AlwaysThrowsExceptionWorkerThread extends ForkJoinWorkerThread {

        /**
         * Constructor of the class. Call the constructor of the
         * parent class
         *
         * @param pool ForkJoinPool where the thread is going to execute
         */
        protected AlwaysThrowsExceptionWorkerThread(ForkJoinPool pool) {
            super(pool);
        }

        /**
         * Method that is going to execute where the Worker Thread
         * begins its execution
         */
        @Override
        protected void onStart() {
            super.onStart();
            throw new RuntimeException("Exception from worker thread");
        }
    }

    /**
     * The ForkJoinPool uses a Factory to create its Working Threads.
     * As we want to use our Working Threads, we need to use our own
     * Factory to create those threads.
     * <p>
     * It implements the interface that every factory has to implement. The
     * ForkJoinWorkerThreadFactory
     */
    public static class AlwaysThrowsExceptionWorkerThreadFactory implements ForkJoinPool.ForkJoinWorkerThreadFactory {

        /**
         * This method creates a new Worker Thread.
         *
         * @param pool The ForkJoinPool where the thread that is creater
         *             is going to execute
         */
        @Override
        public ForkJoinWorkerThread newThread(ForkJoinPool pool) {
            return new AlwaysThrowsExceptionWorkerThread(pool);
        }

    }


}
