package concurrency.collections;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * 用优先级对使用阻塞线程安全的列表排序
 */
public class UsePriorityBlockingQueue {


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

    public static class Task implements Runnable {


        private int id;


        private PriorityBlockingQueue<Event> queue;


        public Task(int id, PriorityBlockingQueue<Event> queue) {
            this.id = id;
            this.queue = queue;
        }


        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                Event event = new Event(id, i);
                queue.add(event);
            }
        }
    }


    public static class Event implements Comparable<Event> {


        private int thread;

        private int priority;

        public Event(int thread, int priority) {
            this.thread = thread;
            this.priority = priority;
        }


        public int getThread() {
            return thread;
        }


        public int getPriority() {
            return priority;
        }

        @Override
        public int compareTo(Event e) {
            if (this.priority > e.getPriority()) {
                return -1;
            } else if (this.priority < e.getPriority()) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
