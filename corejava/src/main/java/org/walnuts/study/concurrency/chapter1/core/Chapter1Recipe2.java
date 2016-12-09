package org.walnuts.study.concurrency.chapter1.core;

import org.walnuts.study.concurrency.chapter1.recipe2.Calculator;

/**
 * 线程的创建和运行
 */
public class Chapter1Recipe2 {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {
            Calculator calculator = new Calculator(i);
            Thread thread = new Thread(calculator);
            thread.start();
        }
    }
}
