package org.walnuts.study.javatuning.ch2.singleton;

public class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton() {
        //创建单例的过程可能会比较慢
        System.out.println("Singleton is create");
    }

    public static Singleton getInstance() {
        return instance;
    }

    public static void createString() {
        System.out.println("createString in Singleton");
    }
}