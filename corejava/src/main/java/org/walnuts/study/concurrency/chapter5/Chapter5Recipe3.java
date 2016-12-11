package org.walnuts.study.concurrency.chapter5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

/**
 * 加入任务的结果
 */
public class Chapter5Recipe3 {


    public static void main(String[] args) {

        DocumentMock mock = new DocumentMock();
        String[][] document = mock.generateDocument(100, 1000, "the");

        long begin = System.currentTimeMillis();
        int count = 0;
        for (String[] strings : document) {
            for (String string : strings) {
                if (string.equals("the")) {
                    count++;
                }
            }
        }
        long mid = System.currentTimeMillis();


        DocumentTask task = new DocumentTask(document, 0, 100, "the");

        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(task);
        do {
            System.out.printf("******************************************\n");
            System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
            System.out.printf("Main: Active Threads: %d\n", pool.getActiveThreadCount());
            System.out.printf("Main: Task Count: %d\n", pool.getQueuedTaskCount());
            System.out.printf("Main: Steal Count: %d\n", pool.getStealCount());
            System.out.printf("******************************************\n");

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } while (!task.isDone());

        pool.shutdown();

        try {
            pool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            System.out.printf("Main: The word appears %d in the document", task.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("");
        System.out.println("--------------------");
        System.out.println(mid - begin);
        System.out.println(end - mid);
    }

    public static class DocumentTask extends RecursiveTask<Integer> {


        private static final long serialVersionUID = 1L;


        private String document[][];


        private int start, end;


        private String word;


        public DocumentTask(String document[][], int start, int end, String word) {
            this.document = document;
            this.start = start;
            this.end = end;
            this.word = word;
        }


        @Override
        protected Integer compute() {
            Integer result = null;
            if (end - start < 10) {
                result = processLines(document, start, end, word);
            } else {
                int mid = (start + end) / 2;
                DocumentTask task1 = new DocumentTask(document, start, mid, word);
                DocumentTask task2 = new DocumentTask(document, mid, end, word);
                invokeAll(task1, task2);
                try {
                    result = groupResults(task1.get(), task2.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
            return result;
        }

        private Integer processLines(String[][] document, int start, int end, String word) {
            List<LineTask> tasks = new ArrayList<>();

            for (int i = start; i < end; i++) {
                LineTask task = new LineTask(document[i], 0, document[i].length, word);
                tasks.add(task);
            }
            invokeAll(tasks);

            int result = 0;
            for (int i = 0; i < tasks.size(); i++) {
                LineTask task = tasks.get(i);
                try {
                    result = result + task.get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
            return new Integer(result);
        }

        private Integer groupResults(Integer number1, Integer number2) {
            return number1 + number2;
        }


    }

    public static class LineTask extends RecursiveTask<Integer> {

        private static final long serialVersionUID = 1L;


        private String line[];


        private int start, end;

        /**
         * Word we are looking for
         */
        private String word;

        public LineTask(String line[], int start, int end, String word) {
            this.line = line;
            this.start = start;
            this.end = end;
            this.word = word;
        }


        @Override
        protected Integer compute() {
            Integer result = null;
            if (end - start < 100) {
                result = count(line, start, end, word);
            } else {
                int mid = (start + end) / 2;
                LineTask task1 = new LineTask(line, start, mid, word);
                LineTask task2 = new LineTask(line, mid, end, word);
                invokeAll(task1, task2);
                try {
                    result = groupResults(task1.get(), task2.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
            return result;
        }

        private Integer groupResults(Integer number1, Integer number2) {
            Integer result;

            result = number1 + number2;
            return result;
        }

        private Integer count(String[] line, int start, int end, String word) {
            int counter;
            counter = 0;
            for (int i = start; i < end; i++) {
                if (line[i].equals(word)) {
                    counter++;
                }
            }
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return counter;
        }


    }

    public static class DocumentMock {

        private String words[] = {"the", "hello", "goodbye", "packt", "java", "thread", "pool", "random", "class", "main"};

        /**
         * Method that generates the String matrix
         *
         * @param numLines Number of lines of the document
         * @param numWords Number of words of the document
         * @param word     Word we are going to search for
         * @return The String matrix
         */
        public String[][] generateDocument(int numLines, int numWords, String word) {

            int counter = 0;
            String document[][] = new String[numLines][numWords];
            Random random = new Random();
            for (int i = 0; i < numLines; i++) {
                for (int j = 0; j < numWords; j++) {
                    int index = random.nextInt(words.length);
                    document[i][j] = words[index];
                    if (document[i][j].equals(word)) {
                        counter++;
                    }
                }
            }
            System.out.printf("DocumentMock: The word appears %d times in the document.\n", counter);
            return document;
        }
    }


}
