package com.packtpub.java7.concurrency.chapter6.core;

import com.packtpub.java7.concurrency.chapter6.recipe03.Client;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * 使用阻塞线程安全的列表
 * 阻塞列表有添加和删除元素的方法，如果由于列表已满或为空而导致这些操作不能立即进行，它们将阻塞调用的线程，直到这些操作可以进行。
 * Java包含实现阻塞列表的LinkedBlockingDeque类
 */
public class Chapter6Recipe3 {


    public static void main(String[] args) throws Exception {

        LinkedBlockingDeque<String> list = new LinkedBlockingDeque<>(3);

        Client client = new Client(list);
        Thread thread = new Thread(client);
        thread.start();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                String request = list.take();//阻塞
                System.out.printf("Main: Request: %s at %s. Size: %d\n", request, new Date(), list.size());
            }
            TimeUnit.MILLISECONDS.sleep(300);
        }

        System.out.printf("Main: End of the program.\n");

    }

}
