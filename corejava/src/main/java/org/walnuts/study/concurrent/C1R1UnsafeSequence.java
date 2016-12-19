package org.walnuts.study.concurrent;

import net.jcip.annotations.*;

/**
 * C1R1UnsafeSequence
 *
 * @author Brian Goetz and Tim Peierls
 */

@NotThreadSafe
public class C1R1UnsafeSequence {
    private int value;

    /**
     * Returns a unique value.
     */
    public int getNext() {
        return value++;
    }
}
