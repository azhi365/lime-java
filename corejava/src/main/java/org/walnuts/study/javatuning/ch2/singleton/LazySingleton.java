package org.walnuts.study.javatuning.ch2.singleton;

public class LazySingleton {
    private static LazySingleton instance = null;

    private LazySingleton() {
        //创建单例的过程可能会比较慢
        System.out.println("LazySingleton is create");
    }

    public static synchronized LazySingleton getInstance() {
        if (instance == null)
            instance = new LazySingleton();
        return instance;
    }
}