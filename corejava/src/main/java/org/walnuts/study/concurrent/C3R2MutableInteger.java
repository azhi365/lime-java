package org.walnuts.study.concurrent;

import net.jcip.annotations.*;

/**
 * C3R2MutableInteger
 * <p/>
 * Non-thread-safe mutable integer holder
 *
 * @author Brian Goetz and Tim Peierls
 */

@NotThreadSafe
public class C3R2MutableInteger {
    private int value;

    public int get() {
        return value;
    }

    public void set(int value) {
        this.value = value;
    }
}








