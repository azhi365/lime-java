package org.walnuts.study.concurrency.chapter1;

/**
 * 线程的创建和运行
 */
public class C1R2Thread {

    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {
            Calculator calculator = new Calculator(i);
            Thread thread = new Thread(calculator);
            thread.start();
        }
    }

    public static class Calculator implements Runnable {

        private int number;
        public Calculator(int number) {
            this.number = number;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                System.out.printf("%s: %d * %d = %d\n", Thread.currentThread().getName(), number, i, i * number);
            }
        }

    }
}


