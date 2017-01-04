package jvm.monitoring;

import java.util.Map;

import static java.lang.System.out;

public class Stack {
    public static void main(String[] args) {
        for (Map.Entry<Thread, StackTraceElement[]> stackTrace : Thread.getAllStackTraces().entrySet()) {
            Thread thread = stackTrace.getKey();
            StackTraceElement[] stack = stackTrace.getValue();
            if (thread.equals(Thread.currentThread())) {
                continue;
            }
            out.print("\n线程：" + thread.getName() + "\n");

            for (StackTraceElement element : stack) {
                out.print("\t" + element + "\n");
            }
        }
    }
}
