package org.walnuts.study.concurrency.chapter3;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 在同一个点同步任务  CyclicBarrier
 */
public class Chapter3Recipe5 {

    public static void main(String[] args) {

        final int rows = 10000;
        final int numbers = 1000;
        final int search = 5;
        final int participants = 5;
        final int linesParticipant = 2000;
        MatrixMock mock = new MatrixMock(rows, numbers, search);

        Results results = new Results(rows);

        Grouper grouper = new Grouper(results);

        CyclicBarrier barrier = new CyclicBarrier(participants, grouper);

        Searcher searchers[] = new Searcher[participants];

        for (int i = 0; i < participants; i++) {
            searchers[i] = new Searcher(i * linesParticipant, (i * linesParticipant) + linesParticipant, mock, results, 5, barrier);
            new Thread(searchers[i]).start();
        }
        System.out.printf("Main: The main thread has finished.\n");
    }

    /**
     * 聚合线程
     */
    public static class Grouper implements Runnable {

        private Results results;

        public Grouper(Results results) {
            this.results = results;
        }

        @Override
        public void run() {
            int finalResult = 0;
            System.out.printf("Grouper: Processing results...\n");
            int data[] = results.getData();
            for (int number : data) {
                finalResult += number;
            }
            System.out.printf("Grouper: Total result: %d.\n", finalResult);
        }

    }

    /**
     * 查找线程
     */
    public static class Searcher implements Runnable {


        private final CyclicBarrier barrier;
        private int firstRow;
        private int lastRow;
        private MatrixMock mock;
        private Results results;
        private int number;

        public Searcher(int firstRow, int lastRow, MatrixMock mock, Results results, int number, CyclicBarrier barrier) {
            this.firstRow = firstRow;
            this.lastRow = lastRow;
            this.mock = mock;
            this.results = results;
            this.number = number;
            this.barrier = barrier;
        }

        @Override
        public void run() {
            int counter;
            System.out.printf("%s: Processing lines from %d to %d.\n", Thread.currentThread().getName(), firstRow, lastRow);
            for (int i = firstRow; i < lastRow; i++) {
                int row[] = mock.getRow(i);
                counter = 0;
                for (int j = 0; j < row.length; j++) {
                    if (row[j] == number) {
                        counter++;
                    }
                }
                results.setData(i, counter);
            }
            System.out.printf("%s: Lines processed.\n", Thread.currentThread().getName());
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * This class generates a random matrix of integer numbers between 1 and 10
     */
    public static class MatrixMock {

        private int data[][];

        public MatrixMock(int size, int length, int number) {

            int counter = 0;
            data = new int[size][length];
            Random random = new Random();
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < length; j++) {
                    data[i][j] = random.nextInt(10);
                    if (data[i][j] == number) {
                        counter++;
                    }
                }
            }
            System.out.printf("Mock: There are %d ocurrences of number in generated data.\n", counter, number);
        }


        public int[] getRow(int row) {
            if ((row >= 0) && (row < data.length)) {
                return data[row];
            }
            return null;
        }

    }


    public static class Results {

        private int data[];

        public Results(int size) {
            data = new int[size];
        }

        public void setData(int position, int value) {
            data[position] = value;
        }

        public int[] getData() {
            return data;
        }
    }

}
