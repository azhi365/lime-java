package concurrency.threadmanage;


public class ThreadStart {

    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {
            Calculator calculator = new Calculator(i);
            java.lang.Thread thread = new java.lang.Thread(calculator);
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
                System.out.printf("%s: %d * %d = %d\n", java.lang.Thread.currentThread().getName(), number, i, i * number);
            }
        }

    }
}


