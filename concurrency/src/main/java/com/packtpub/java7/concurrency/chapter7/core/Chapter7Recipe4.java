package com.packtpub.java7.concurrency.chapter7.core;


import com.packtpub.java7.concurrency.chapter7.recipe04.MyTask;
import com.packtpub.java7.concurrency.chapter7.recipe04.MyThreadFactory;

/**
 * 实现ThreadFactory接口生成自定义的线程
 */
public class Chapter7Recipe4 {


    public static void main(String[] args) throws Exception {

        MyThreadFactory myFactory = new MyThreadFactory("MyThreadFactory");


        MyTask task = new MyTask();
        Thread thread = myFactory.newThread(task);
        thread.start();
        thread.join();
        System.out.printf("Main: Thread information.\n");
        System.out.printf("%s\n", thread);
        System.out.printf("Main: End of the example.\n");

    }

}
