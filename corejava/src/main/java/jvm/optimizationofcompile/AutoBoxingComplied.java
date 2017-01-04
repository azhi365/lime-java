package jvm.optimizationofcompile;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 自动装箱、拆箱与遍历循环编译之后
 */
public class AutoBoxingComplied {
    public static void main(String[] args) {
        List list = Arrays.asList(new Integer[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4)});

        int sum = 0;
        for (Iterator localIterator = list.iterator(); localIterator.hasNext(); ) {
            int i = ((Integer) localIterator.next()).intValue();
            sum += i;
        }
        System.out.println(sum);
    }


}
