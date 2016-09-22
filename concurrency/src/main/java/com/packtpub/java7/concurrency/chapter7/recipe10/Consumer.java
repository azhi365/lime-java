package com.packtpub.java7.concurrency.chapter7.recipe10;

/**
 * This class implements the Consumer of the events. There is only
 * one consumer in the example that consumes 1002 events
 */
public class Consumer implements Runnable {


    private MyPriorityTransferQueue<Event> buffer;


    public Consumer(MyPriorityTransferQueue<Event> buffer) {
        this.buffer = buffer;
    }


    @Override
    public void run() {
        for (int i = 0; i < 1002; i++) {
            try {
                Event value = buffer.take();
                System.out.printf("Consumer: %s: %d\n", value.getThread(), value.getPriority());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
