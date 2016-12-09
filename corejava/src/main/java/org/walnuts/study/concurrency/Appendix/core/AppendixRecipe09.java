package org.walnuts.study.concurrency.Appendix.core;

import org.walnuts.study.concurrency.Appendix.recipe09.task.Task;

import java.util.concurrent.locks.ReentrantLock;

public class AppendixRecipe09 {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        for (int i = 0; i < 10; i++) {
            Task task = new Task(lock);
            Thread thread = new Thread(task);
            thread.start();
        }
    }
}
