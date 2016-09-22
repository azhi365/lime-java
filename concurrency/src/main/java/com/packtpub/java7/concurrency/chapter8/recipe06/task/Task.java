package com.packtpub.java7.concurrency.chapter8.recipe06.task;

import com.packtpub.java7.concurrency.chapter8.recipe06.logger.MyLogger;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


public class Task implements Runnable {


    @Override
    public void run() {

        Logger logger = MyLogger.getLogger(this.getClass().getName());

        logger.entering(Thread.currentThread().getName(), "run()");


        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        logger.exiting(Thread.currentThread().getName(), "run()", Thread.currentThread());
    }
}
