package org.walnuts.study.concurrent;

import net.jcip.annotations.NotThreadSafe;

/**
 * C2R3LazyInitRace
 * <p>
 * Race condition in lazy initialization
 *
 * @author Brian Goetz and Tim Peierls
 */

@NotThreadSafe
public class C2R3LazyInitRace {
    private ExpensiveObject instance = null;

    public ExpensiveObject getInstance() {
        if (instance == null)
            instance = new ExpensiveObject();
        return instance;
    }

    class ExpensiveObject {}
}



