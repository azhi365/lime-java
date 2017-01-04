package jvm.executionengine;

/**
 * 局部变量表Slot复用对垃圾收集的影响之一
 * -verbose:gc
 */
public class Slot1 {
    public static void main(String[] args) {
        byte[] placeholder = new byte[64 * 1024 * 1024];
        System.gc();
    }
}
