package com.packtpub.java7.concurrency.chapter3.core;

import com.packtpub.java7.concurrency.chapter3.recipe4.Participant;
import com.packtpub.java7.concurrency.chapter3.recipe4.VideoConference;

/**
 * 等待多个并发事件完成 CountDownLatch
 */
public class Chapter1Recipe4 {


    public static void main(String[] args) {

        VideoConference conference = new VideoConference(10);

        new Thread(conference).start();

        for (int i = 0; i < 10; i++) {
            new Thread(new Participant(conference, "Participant " + i)).start();
        }

    }

}
