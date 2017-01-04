package jvm.executionengine;

/**
 * 局部变量表Slot复用对垃圾收集的影响之二
 * -verbose:gc
 */
public class Slot2 {
    public static void main(String[] args) {
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
        }
        System.gc();
    }
}
