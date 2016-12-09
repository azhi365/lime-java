package org.walnuts.study.concurrency.chapter2.core;


import org.walnuts.study.concurrency.chapter2.recipe8.task.Buffer;
import org.walnuts.study.concurrency.chapter2.recipe8.task.Consumer;
import org.walnuts.study.concurrency.chapter2.recipe8.task.Producer;
import org.walnuts.study.concurrency.chapter2.recipe8.utils.FileMock;

/**
 * 在Lock中使用多个条件
 */
public class Chapter2Recipe8 {


    public static void main(String[] args) {

        FileMock mock = new FileMock(101, 10);

        Buffer buffer = new Buffer(20);

        Producer producer = new Producer(mock, buffer);
        Thread threadProducer = new Thread(producer, "Producer");


        Consumer consumers[] = new Consumer[3];
        Thread threadConsumers[] = new Thread[3];

        for (int i = 0; i < 3; i++) {
            consumers[i] = new Consumer(buffer);
            threadConsumers[i] = new Thread(consumers[i], "Consumer " + i);
        }


        threadProducer.start();
        for (int i = 0; i < 3; i++) {
            threadConsumers[i].start();
        }
    }

}
