package com.packtpub.java7.concurrency.chapter4.core;

import com.packtpub.java7.concurrency.chapter4.recipe2.Server;
import com.packtpub.java7.concurrency.chapter4.recipe2.Task;


/**
 * <pre>
 * 创建一个线程执行者:
 * 你已创建的缓存线程池，当需要执行新的任务会创建新的线程，如果它们已经完成运行任务，变成可用状态，会重新使用这些线程。线程重复利用的好处是，它减少线程创建的时间。
 * 缓存线程池的缺点是，为新任务不断创建线程， 所以如果你提交过多的任务给执行者，会使系统超载。
 * 注意事项：使用通过newCachedThreadPool()方法创建的执行者，只有当你有一个合理的线程数或任务有一个很短的执行时间。
 * </pre>
 */
public class Chapter4Recipe2 {


    public static void main(String[] args) {

        Server server = new Server();
        for (int i = 0; i < 100; i++) {
            Task task = new Task("Task " + i);
            server.executeTask(task);
        }

        server.endServer();

    }

}
