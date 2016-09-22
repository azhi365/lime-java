package com.packtpub.java7.concurrency.chapter3.recipe5.utils;


/**
 * 保存结果
 */
public class Results {

    private int data[];

    public Results(int size) {
        data = new int[size];
    }

    public void setData(int position, int value) {
        data[position] = value;
    }

    public int[] getData() {
        return data;
    }
}
