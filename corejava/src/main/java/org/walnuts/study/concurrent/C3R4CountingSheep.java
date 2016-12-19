package org.walnuts.study.concurrent;

/**
 * C3R4CountingSheep
 * <p/>
 * Counting sheep
 *
 * @author Brian Goetz and Tim Peierls
 */
public class C3R4CountingSheep {
    volatile boolean asleep;

    void tryToSleep() {
        while (!asleep)
            countSomeSheep();
    }

    void countSomeSheep() {
        // One, two, three...
    }
}








