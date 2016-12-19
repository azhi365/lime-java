package org.walnuts.study.concurrency.chapter2;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 使用读/写锁来同步数据访问
 */
public class C2R6ReadWriteLock {


    public static void main(String[] args) {

        PricesInfo pricesInfo = new PricesInfo();

        Reader readers[] = new Reader[5];
        Thread threadsReader[] = new Thread[5];
        for (int i = 0; i < 5; i++) {
            readers[i] = new Reader(pricesInfo);
            threadsReader[i] = new Thread(readers[i]);
        }


        Writer writer = new Writer(pricesInfo);
        Thread threadWriter = new Thread(writer);
        for (int i = 0; i < 5; i++) {
            threadsReader[i].start();
        }
        threadWriter.start();

    }

    public static class Reader implements Runnable {
        private PricesInfo pricesInfo;

        public Reader(PricesInfo pricesInfo) {
            this.pricesInfo = pricesInfo;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.printf("%s: Price 1: %f\n", Thread.currentThread().getName(), pricesInfo.getPrice1());
                System.out.printf("%s: Price 2: %f\n", Thread.currentThread().getName(), pricesInfo.getPrice2());
            }
        }

    }

    public static class Writer implements Runnable {

        private PricesInfo pricesInfo;

        public Writer(PricesInfo pricesInfo) {
            this.pricesInfo = pricesInfo;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.printf("Writer: Attempt to modify the prices.\n");
                pricesInfo.setPrices(Math.random() * 10, Math.random() * 8);
                System.out.printf("Writer: Prices have been modified.\n");
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    /**
     * This class simulates the store of two prices. We will
     * have a writer that stores the prices and readers that
     * consult this prices
     */
    public static class PricesInfo {


        private double price1;
        private double price2;


        private ReadWriteLock lock;

        /**
         * Constructor of the class. Initializes the prices and the Lock
         */
        public PricesInfo() {
            price1 = 1.0;
            price2 = 2.0;
            lock = new ReentrantReadWriteLock();
        }

        /**
         * Returns the first price
         *
         * @return the first price
         */
        public double getPrice1() {
            lock.readLock().lock();
            double value = price1;
            lock.readLock().unlock();
            return value;
        }

        /**
         * Returns the second price
         *
         * @return the second price
         */
        public double getPrice2() {
            lock.readLock().lock();
            double value = price2;
            lock.readLock().unlock();
            return value;
        }

        /**
         * Establish the prices
         *
         * @param price1 The price of the first product
         * @param price2 The price of the second product
         */
        public void setPrices(double price1, double price2) {
            lock.writeLock().lock();
            this.price1 = price1;
            this.price2 = price2;
            lock.writeLock().unlock();
        }
    }

}
