package org.walnuts.study.concurrent;

/**
 * C3R8SafeListener
 * <p/>
 * Using a factory method to prevent the this reference from escaping during construction
 *
 * @author Brian Goetz and Tim Peierls
 */
public class C3R8SafeListener {
    private final EventListener listener;

    private C3R8SafeListener() {
        listener = new EventListener() {
            public void onEvent(Event e) {
                doSomething(e);
            }
        };
    }

    public static C3R8SafeListener newInstance(EventSource source) {
        C3R8SafeListener safe = new C3R8SafeListener();
        source.registerListener(safe.listener);
        return safe;
    }

    void doSomething(Event e) {
    }


    interface EventSource {
        void registerListener(EventListener e);
    }

    interface EventListener {
        void onEvent(Event e);
    }

    interface Event {
    }
}

