package org.walnuts.study.concurrent;

import net.jcip.annotations.*;

/**
 * C1R2Sequence
 *
 * @author Brian Goetz and Tim Peierls
 */

@ThreadSafe
public class C1R2Sequence {
    @GuardedBy("this") private int nextValue;

    public synchronized int getNext() {
        return nextValue++;
    }
}
