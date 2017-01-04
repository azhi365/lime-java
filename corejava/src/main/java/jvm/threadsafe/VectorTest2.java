package jvm.threadsafe;

import java.util.Vector;

/**
 * 必须加入同步以保证Vector访问的线程安全性
 */
public class VectorTest2 {
    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        Thread removeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (vector) {
                    for (int i = 0; i < vector.size(); i++) {
                        vector.remove(i);
                    }
                }
            }
        });

        Thread printThread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (vector) {
                    for (int i = 0; i < vector.size(); i++) {
                        System.out.println((vector.get(i)));
                    }
                }
            }
        });

    }
}
