package com.packtpub.java7.concurrency.chapter6.recipe06.util;


public class Contact {

    private String name;
    private String phone;


    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }


    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }
}
