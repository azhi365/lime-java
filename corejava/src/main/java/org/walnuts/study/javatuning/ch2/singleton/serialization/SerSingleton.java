package org.walnuts.study.javatuning.ch2.singleton.serialization;

public class SerSingleton implements java.io.Serializable {
    private static SerSingleton instance = new SerSingleton();
    String name;

    private SerSingleton() {
        //创建单例的过程可能会比较慢
        System.out.println("Singleton is create");
        name = "SerSingleton";
    }

    public static SerSingleton getInstance() {
        return instance;
    }

    public static void createString() {
        System.out.println("createString in Singleton");
    }

    private Object readResolve() {
        return instance;
    }
}