package org.walnuts.study.concurrency.chapter5.recipe06.util;

import org.walnuts.study.concurrency.chapter5.recipe06.task.SearchNumberTask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;


public class TaskManager {


    private List<ForkJoinTask<Integer>> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }


    public void addTask(ForkJoinTask<Integer> task) {
        tasks.add(task);
    }


    /**
     * 取消其它任务
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
