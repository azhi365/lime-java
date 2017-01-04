package concurrency.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

/**
 * 取消任务
 */
public class CancelTask {


    public static void main(String[] args) {

        ArrayGenerator generator = new ArrayGenerator();
        int array[] = generator.generateArray(1000);

        TaskManager manager = new TaskManager();

        ForkJoinPool pool = new ForkJoinPool();

        SearchNumberTask task = new SearchNumberTask(array, 0, 1000, 5, manager);

        pool.execute(task);
        pool.shutdown();


        try {
            pool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Main: The program has finished\n");
    }

    /**
     * This task look for a number in an array of integer numbers.
     * If the part of the array it has to process has more than
     * 10 elements, it creates two subtasks and executes then asynchronously
     * with the fork method. Otherwise, look for the number in the block
     * it has to process.
     * <p>
     * If the task found the number, return the position where the number has
     * been found. Else, return the -1 value. If a subtask found the number,
     * the tasks suspend the other subtask and return the position where the number
     * has been found. If none of the two subtasks found the number, return the -1
     * value.
     */
    public static class SearchNumberTask extends RecursiveTask<Integer> {


        private static final long serialVersionUID = 1L;


        private final static int NOT_FOUND = -1;
        private int numbers[];
        private int start, end;
        /**
         * target
         */
        private int number;
        private TaskManager manager;

        public SearchNumberTask(int numbers[], int start, int end, int number, TaskManager manager) {
            this.numbers = numbers;
            this.start = start;
            this.end = end;
            this.number = number;
            this.manager = manager;
        }

        @Override
        protected Integer compute() {
            System.out.println("Task: " + start + ":" + end);
            int ret;
            if (end - start > 10) {
                ret = launchTasks();
            } else {
                ret = lookForNumber();
            }
            return new Integer(ret);
        }


        private int lookForNumber() {
            for (int i = start; i < end; i++) {
                if (numbers[i] == number) {
                    System.out.printf("Task: Number %d found in position %d\n", number, i);
                    manager.cancelTasks(this);
                    return i;
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return NOT_FOUND;
        }


        private int launchTasks() {
            int mid = (start + end) / 2;

            SearchNumberTask task1 = new SearchNumberTask(numbers, start, mid, number, manager);
            SearchNumberTask task2 = new SearchNumberTask(numbers, mid, end, number, manager);

            manager.addTask(task1);
            manager.addTask(task2);

            task1.fork();
            task2.fork();
            int returnValue;

            returnValue = task1.join();
            if (returnValue != -1) {
                return returnValue;
            }

            returnValue = task2.join();
            return returnValue;
        }

        public void writeCancelMessage() {
            System.out.printf("Task: Cancelled task from %d to %d\n", start, end);
        }

    }

    public static class ArrayGenerator {

        public int[] generateArray(int size) {
            int array[] = new int[size];
            Random random = new Random();
            for (int i = 0; i < size; i++) {
                array[i] = random.nextInt(10);
            }
            return array;
        }

    }

    public static class TaskManager {


        private List<ForkJoinTask<Integer>> tasks;

        public TaskManager() {
            tasks = new ArrayList<>();
        }


        public void addTask(ForkJoinTask<Integer> task) {
            tasks.add(task);
        }


        /**
         * 取消其它任务
         *
         * @param cancelTask
         */
        public void cancelTasks(ForkJoinTask<Integer> cancelTask) {
            for (ForkJoinTask<Integer> task : tasks) {
                if (task != cancelTask) {
                    task.cancel(true);
                    ((SearchNumberTask) task).writeCancelMessage();
                }
            }
        }
    }

}
