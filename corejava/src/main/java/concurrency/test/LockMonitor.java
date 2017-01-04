package concurrency.test;

import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 监控Lock接口
 */
public class LockMonitor {

    public static void main(String[] args) throws Exception {

        MyLock lock = new MyLock();


        Thread threads[] = new Thread[5];


        for (int i = 0; i < 5; i++) {
            Task task = new Task(lock);
            threads[i] = new Thread(task);
            threads[i].start();
        }


        for (int i = 0; i < 15; i++) {

            System.out.printf("Main: Logging the Lock\n");
            System.out.printf("************************\n");
            System.out.printf("Lock: Owner : %s\n", lock.getOwnerName());
            System.out.printf("Lock: Queued Threads: %s\n", lock.hasQueuedThreads());
            if (lock.hasQueuedThreads()) {
                System.out.printf("Lock: Queue Length: %d\n", lock.getQueueLength());
                System.out.printf("Lock: Queued Threads: ");
                Collection<Thread> lockedThreads = lock.getThreads();
                for (Thread lockedThread : lockedThreads) {
                    System.out.printf("%s ", lockedThread.getName());
                }
                System.out.printf("\n");
            }
            System.out.printf("Lock: Fairness: %s\n", lock.isFair());
            System.out.printf("Lock: Locked: %s\n", lock.isLocked());
            System.out.printf("************************\n");

            TimeUnit.SECONDS.sleep(1);
        }
    }

    public static class Task implements Runnable {


        private Lock lock;


        public Task(Lock lock) {
            this.lock = lock;
        }


        @Override
        public void run() {

            for (int i = 0; i < 5; i++) {

                lock.lock();
                System.out.printf("%s: Get the Lock.\n", Thread.currentThread().getName());

                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                    System.out.printf("%s: Free the Lock.\n", Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        }
    }

    public static class MyLock extends ReentrantLock {

        private static final long serialVersionUID = 1L;


        public String getOwnerName() {
            if (this.getOwner() == null) {
                return "None";
            }
            return this.getOwner().getName();
        }

        public Collection<Thread> getThreads() {
            return this.getQueuedThreads();
        }
    }

}
