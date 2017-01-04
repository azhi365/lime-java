package concurrency.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 死锁示例
 */
public class DeadLock {


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
    public static class Task1 implements Runnable {

        private Lock lock1, lock2;


        public Task1(Lock lock1, Lock lock2) {
            this.lock1 = lock1;
            this.lock2 = lock2;
        }

        @Override
        public void run() {
            lock1.lock();
            System.out.printf("Task 1: Lock 1 locked\n");
            lock2.lock();
            System.out.printf("Task 1: Lock 2 locked\n");
            lock2.unlock();
            lock1.unlock();
        }

    }


    /**
     * This task implements the second task of the example
     */
    public static class Task2 implements Runnable{

        /**
         * Two locks used by the example
         */
        private Lock lock1, lock2;

        /**
         * Constructor for the class. Initialize its attributes
         * @param lock1 A lock used by the class
         * @param lock2 A lock used by the class
         */
        public Task2(Lock lock1, Lock lock2) {
            this.lock1=lock1;
            this.lock2=lock2;
        }

        /**
         * Main method of the task
         */
        @Override
        public void run() {
            lock2.lock();
            System.out.printf("Task 2: Lock 2 locked\n");
            lock1.lock();
            System.out.printf("Task 2: Lock 1 locked\n");
            lock1.unlock();
            lock2.unlock();
        }

    }

}
