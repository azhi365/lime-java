package org.walnuts.study.concurrency.chapter4.recipe8;

import java.util.Date;


public class Task implements Runnable {

    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.printf("%s: Executed at: %s\n", name, new Date());
    }

}
