package base;

import org.junit.Test;

import java.util.BitSet;
import java.util.Properties;

/**
 * Created by YZhi on 2015/12/29.
 */

public class BaseTest {
    @Test
    public void test() {
        Properties properties = new Properties();
        BitSet bitSet = new BitSet();
        bitSet.set(1);
        System.out.println(bitSet.get(2));
    }
}
