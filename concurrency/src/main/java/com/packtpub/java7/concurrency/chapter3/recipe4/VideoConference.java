package com.packtpub.java7.concurrency.chapter3.recipe4;

import java.util.concurrent.CountDownLatch;

/**
 * This class implements the countDownLatch of the Videoconference
 * <p/>
 * It uses a CountDownLatch to control the arrival of all the
 * participants in the conference.
 */
public class VideoConference implements Runnable {


    private final CountDownLatch countDownLatch;


    public VideoConference(int number) {
        this.countDownLatch = new CountDownLatch(number);
    }


    public void arrive(String name) {
        System.out.printf("%s has arrived.\n", name);
        countDownLatch.countDown();
        System.out.printf("VideoConference: Waiting for %d participants.\n", countDownLatch.getCount());
    }

    @Override
    public void run() {
        System.out.printf("VideoConference: Initialization: %d participants.\n", countDownLatch.getCount());
        try {
            countDownLatch.await();
            System.out.printf("VideoConference: All the participants have come\n");
            System.out.printf("VideoConference: Let's start...\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
