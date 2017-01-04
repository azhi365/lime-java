package jvm.threadsafe;

/**
 * Created by YZhi on 1/4/2017.
 */
public class Atomic {
    /**
     * Atomically increment by one the current value.
     *
     * @return the updated value
     */
    public final int incrementAndGet() {
        for (; ; ) {
            int current = get();
            int next = current + 1;
            if (compareAndSet(current, next))
                return next;
        }
    }

    private boolean compareAndSet(int current, int next) {
        return false;
    }

    private int get() {
        return 0;
    }

}
