package concurrency.customization;

import java.util.concurrent.*;

/**
 * 实现ThreadFactory接口生成自定义的线程给Fork/Join框架
 */
public class ForkJoinExecutor {

    public static void main(String[] args) throws Exception {

        MyWorkerThreadFactory factory = new MyWorkerThreadFactory();

        ForkJoinPool pool = new ForkJoinPool(4, factory, null, false);


        int array[] = new int[100000];

        for (int i = 0; i < array.length; i++) {
            array[i] = 1;
        }

        MyRecursiveTask task = new MyRecursiveTask(array, 0, array.length);

        pool.execute(task);

        task.join();

        pool.shutdown();

        pool.awaitTermination(1, TimeUnit.DAYS);


        System.out.printf("Main: Result: %d\n", task.get());
        System.out.printf("Main: End of the program\n");
    }

    public static class MyRecursiveTask extends RecursiveTask<Integer> {


        private static final long serialVersionUID = 1L;


        private int array[];

        private int start, end;


        public MyRecursiveTask(int array[], int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }


        @Override
        protected Integer compute() {
            Integer ret;
            MyWorkerThread thread = (MyWorkerThread) Thread.currentThread();
            thread.addTask();
            if (end - start > 100) {
                int mid = (start + end) / 2;
                MyRecursiveTask task1 = new MyRecursiveTask(array, start, mid);
                MyRecursiveTask task2 = new MyRecursiveTask(array, mid, end);
                invokeAll(task1, task2);
                ret = addResults(task1, task2);
            } else {
                int add = 0;
                for (int i = start; i < end; i++) {
                    add += array[i];
                }
                ret = new Integer(add);
            }
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return ret;
        }

        private Integer addResults(MyRecursiveTask task1, MyRecursiveTask task2) {
            int value;
            try {
                value = task1.get().intValue() + task2.get().intValue();
            } catch (InterruptedException e) {
                e.printStackTrace();
                value = 0;
            } catch (ExecutionException e) {
                e.printStackTrace();
                value = 0;
            }
            return new Integer(value);
        }

    }

    public static class MyWorkerThread extends ForkJoinWorkerThread {


        private static ThreadLocal<Integer> taskCounter = new ThreadLocal<>();

        protected MyWorkerThread(ForkJoinPool pool) {
            super(pool);
        }


        @Override
        protected void onStart() {
            super.onStart();
            System.out.printf("MyWorkerThread %d: Initializing task counter.\n", getId());
            taskCounter.set(0);
        }


        @Override
        protected void onTermination(Throwable exception) {
            System.out.printf("MyWorkerThread %d: %d\n", getId(), taskCounter.get());
            super.onTermination(exception);
        }


        public void addTask() {
            int counter = taskCounter.get().intValue();
            counter++;
            taskCounter.set(counter);
        }

    }

    public static class MyWorkerThreadFactory implements ForkJoinPool.ForkJoinWorkerThreadFactory {


        @Override
        public ForkJoinWorkerThread newThread(ForkJoinPool pool) {
            return new MyWorkerThread(pool);
        }

    }



}
