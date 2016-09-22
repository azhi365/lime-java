package com.packtpub.java7.concurrency.chapter2.recipe8.task;

import java.util.Random;

/**
 * This class reads line from the buffer and process it
 */
public class Consumer implements Runnable {


    private Buffer buffer;


    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }


    @Override
    public void run() {
        while (buffer.hasPendingLines()) {
            String line = buffer.get();
            processLine(line);
        }
    }


    private void processLine(String line) {
        try {
            Random random = new Random();
            Thread.sleep(random.nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
