package org.walnuts.study.concurrency.chapter2;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * 在同步代码中使用条件 生产者-消费者
 */
public class C2R4ProducerConsumer {


    public static void main(String[] args) {

        EventStorage storage = new EventStorage();

        Producer producer = new Producer(storage);
        Thread thread1 = new Thread(producer);

        Consumer consumer = new Consumer(storage);
        Thread thread2 = new Thread(consumer);

        thread2.start();
        thread1.start();
    }

    /**
     * This class implements a consumer of events.
     */
    public static class Consumer implements Runnable {

        private EventStorage storage;

        public Consumer(EventStorage storage) {
            this.storage = storage;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                storage.get();
            }
        }

    }

    public static class Producer implements Runnable {


        private EventStorage storage;


        public Producer(EventStorage storage) {
            this.storage = storage;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                storage.set();
            }
        }
    }


    public static class EventStorage {


        private int maxSize;

        private List<Date> storage;


        public EventStorage() {
            maxSize = 10;
            storage = new LinkedList<>();
        }

        public synchronized void set() {
            while (storage.size() == maxSize) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            storage.add(new Date());
            System.out.printf("Set: %d", storage.size());
            System.out.println();
            notify();
        }


        public synchronized void get() {
            while (storage.size() == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.printf("Get: %d: %s", storage.size(), ((LinkedList<?>) storage).poll());
            System.out.println();
            notify();
        }

    }

}
