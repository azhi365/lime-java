package org.walnuts.study.concurrency.chapter2.recipe8.task;

import org.walnuts.study.concurrency.chapter2.recipe8.utils.FileMock;


public class Producer implements Runnable {


    private FileMock mock;


    private Buffer buffer;


    public Producer(FileMock mock, Buffer buffer) {
        this.mock = mock;
        this.buffer = buffer;
    }


    @Override
    public void run() {
        buffer.setPendingLines(true);
        while (mock.hasMoreLines()) {
            String line = mock.getLine();
            buffer.insert(line);
        }
        buffer.setPendingLines(false);
    }

}
