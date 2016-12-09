package org.walnuts.study.jvm.Chapter02;

/**
 * VM Args：-Xss2M （这时候不妨设大些）
 *
 * @author zzm
 */
public class JavaVMStackOOM {

    public static void main(String[] args) throws Throwable {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }

    private void dontStop() {
        while (true) {
        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(() -> {
                dontStop();
            });
            thread.start();
        }
    }
}

