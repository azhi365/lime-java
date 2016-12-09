package org.walnuts.study.concurrency.chapter5.recipe06.task;

import org.walnuts.study.concurrency.chapter5.recipe06.util.TaskManager;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

/**
 * This task look for a number in an array of integer numbers.
 * If the part of the array it has to process has more than
 * 10 elements, it creates two subtasks and executes then asynchronously
 * with the fork method. Otherwise, look for the number in the block
 * it has to process.
 * <p/>
 * If the task found the number, return the position where the number has
 * been found. Else, return the -1 value. If a subtask found the number,
 * the tasks suspend the other subtask and return the position where the number
 * has been found. If none of the two subtasks found the number, return the -1
 * value.
 */
public class SearchNumberTask extends RecursiveTask<Integer> {


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
