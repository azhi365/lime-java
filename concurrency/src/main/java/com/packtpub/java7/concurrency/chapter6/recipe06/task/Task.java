package com.packtpub.java7.concurrency.chapter6.recipe06.task;

import com.packtpub.java7.concurrency.chapter6.recipe06.util.Contact;

import java.util.concurrent.ConcurrentSkipListMap;


public class Task implements Runnable {


    private ConcurrentSkipListMap<String, Contact> map;

    /**
     * Id of the task
     */
    private String id;


    public Task(ConcurrentSkipListMap<String, Contact> map, String id) {
        this.id = id;
        this.map = map;
    }


    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Contact contact = new Contact(id, String.valueOf(i + 1000));
            map.put(id + contact.getPhone(), contact);
        }
    }


}
