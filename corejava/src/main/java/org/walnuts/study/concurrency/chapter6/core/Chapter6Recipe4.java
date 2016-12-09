package org.walnuts.study.concurrency.chapter6.core;

import org.walnuts.study.concurrency.chapter6.recipe04.Event;
import org.walnuts.study.concurrency.chapter6.recipe04.Task;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * 用优先级对使用阻塞线程安全的列表排序
 */
public class Chapter6Recipe4 {


    public static void main(String[] args) {

        PriorityBlockingQueue<Event> queue = new PriorityBlockingQueue<>();


        Thread taskThreads[] = new Thread[5];


        for (int i = 0; i < taskThreads.length; i++) {
            taskThreads[i] = new Thread(new Task(i, queue));
        }


        for (int i = 0; i < taskThreads.length; i++) {
            taskThreads[i].start();
        }

        for (int i = 0; i < taskThreads.length; i++) {
            try {
                taskThreads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Main: Queue Size: %d\n", queue.size());
        for (int i = 0; i < taskThreads.length * 1000; i++) {
            Event event = queue.poll();
            System.out.printf("Thread %s: Priority %d\n", event.getThread(), event.getPriority());
        }
        System.out.printf("Main: Queue Size: %d\n", queue.size());
        System.out.printf("Main: End of the program\n");
    }
}
