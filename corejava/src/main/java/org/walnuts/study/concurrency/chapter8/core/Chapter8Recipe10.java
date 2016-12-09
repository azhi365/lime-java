package org.walnuts.study.concurrency.chapter8.core;

import org.walnuts.study.concurrency.chapter8.recipe10.ProducerConsumerTest;
import edu.umd.cs.mtc.TestFramework;

public class Chapter8Recipe10 {

    public static void main(String[] args) throws Throwable {

        ProducerConsumerTest test = new ProducerConsumerTest();

        System.out.printf("Main: Starting the test\n");
        TestFramework.runOnce(test);
        System.out.printf("Main: The test has finished\n");
    }
}