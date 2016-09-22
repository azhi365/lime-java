package com.packtpub.java7.concurrency.chapter4.core;

import com.packtpub.java7.concurrency.chapter4.recipe3.Server;
import com.packtpub.java7.concurrency.chapter4.recipe3.Task;

/**
 * 创建一个大小固定的线程执行者:
 *
 * 这个执行者有最大线程数。 如果你提交超过这个最大线程数的任务，这个执行者将不会创建额外的线程，并且剩下的任务将会阻塞，直到执行者有空闲线程。这种行为，保证执行者不会引发应用程序性能不佳的问题。
 */
public class Chapter4Recipe3 {


    public static void main(String[] args) {
        Server server = new Server();

        for (int i = 0; i < 100; i++) {
            Task task = new Task("Task " + i);
            server.executeTask(task);
        }

        server.endServer();

    }

}
