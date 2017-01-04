package concurrency.basicsynchronized;


import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 在Lock中使用多个条件
 */
public class LockCondition {


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

    /**
     * This class reads line from the buffer and process it
     */
    public static class Consumer implements Runnable {


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

    public static class Producer implements Runnable {


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

    public static class FileMock {


        private String content[];

        private int index;

        public FileMock(int size, int length) {
            content = new String[size];
            for (int i = 0; i < size; i++) {
                StringBuilder buffer = new StringBuilder(length);
                for (int j = 0; j < length; j++) {
                    int indice = (int) Math.random() * 255;
                    buffer.append((char) indice);
                }
                content[i] = buffer.toString();
            }
            index = 0;
        }


        public boolean hasMoreLines() {
            return index < content.length;
        }


        public String getLine() {
            if (this.hasMoreLines()) {
                System.out.println("Mock: " + (content.length - index));
                return content[index++];
            }
            return null;
        }

    }

    /**
     * This class implements a buffer to stores the simulate file lines between the
     * producer and the consumers
     */
    public static class Buffer {

        /**
         * The buffer
         */
        private LinkedList<String> buffer;

        /**
         * Size of the buffer
         */
        private int maxSize;

        /**
         * Lock to control the access to the buffer
         */
        private ReentrantLock lock;

        /**
         * Conditions to control that the buffer has lines and has empty space
         */
        private Condition lines;
        private Condition space;

        /**
         * Attribute to control where are pending lines in the buffer
         */
        private boolean pendingLines;

        public Buffer(int maxSize) {
            this.maxSize = maxSize;
            buffer = new LinkedList<>();
            lock = new ReentrantLock();
            lines = lock.newCondition();
            space = lock.newCondition();
            pendingLines = true;
        }

        public void insert(String line) {
            lock.lock();
            try {
                while (buffer.size() == maxSize) {
                    space.await();
                }
                buffer.offer(line);
                System.out.printf("%s: Inserted Line: %d\n", Thread.currentThread().getName(), buffer.size());
                lines.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public String get() {
            String line = null;
            lock.lock();
            try {
                while ((buffer.size() == 0) && (hasPendingLines())) {
                    lines.await();
                }

                if (hasPendingLines()) {
                    line = buffer.poll();
                    System.out.printf("%s: Line Readed: %d\n", Thread.currentThread().getName(), buffer.size());
                    space.signalAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            return line;
        }


        public void setPendingLines(boolean pendingLines) {
            this.pendingLines = pendingLines;
        }


        public boolean hasPendingLines() {
            return pendingLines || buffer.size() > 0;
        }

    }


}
