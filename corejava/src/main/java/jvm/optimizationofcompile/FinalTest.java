package jvm.optimizationofcompile;

/**
 * Created by YZhi on 1/4/2017.
 */
public class FinalTest {
    // 方法一带有final修饰
    public void foo(final int arg) {
        final int var = 0;
        // do something
    }

    // 方法二没有final修饰
    public void foo2(int arg) {
        int var = 0;
        // do something
    }
}
