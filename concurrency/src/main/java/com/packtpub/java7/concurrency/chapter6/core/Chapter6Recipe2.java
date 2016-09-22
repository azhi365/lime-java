package com.packtpub.java7.concurrency.chapter6.core;

import com.packtpub.java7.concurrency.chapter6.recipe02.AddTask;
import com.packtpub.java7.concurrency.chapter6.recipe02.PollTask;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * 使用非阻塞线程安全的列表
 *
 * 非阻塞列表提供这些操作：如果操作不能立即完成（比如，你想要获取列表的元素而列表却是空的），它将根据这个操作抛出异常或返回null值。
 * Java 7引进实现了非阻塞并发列表的ConcurrentLinkedDeque类
 */
public class Chapter6Recipe2 {

    public static void main(String[] args) throws Exception {

        ConcurrentLinkedDeque<String> list = new ConcurrentLinkedDeque<>();

        Thread threads[] = new Thread[100];

        for (int i = 0; i < threads.length; i++) {
            AddTask task = new AddTask(list);
            threads[i] = new Thread(task);
            threads[i].start();
        }
        System.out.printf("Main: %d AddTask threads have been launched\n", threads.length);

        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }


        System.out.printf("Main: Size of the List: %d\n", list.size());

        for (int i = 0; i < threads.length; i++) {
            PollTask task = new PollTask(list);
            threads[i] = new Thread(task);
            threads[i].start();
        }
        System.out.printf("Main: %d PollTask threads have been launched\n", threads.length);

        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }

        System.out.printf("Main: Size of the List: %d\n", list.size());
    }
}
