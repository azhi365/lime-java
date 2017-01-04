package jvm.optimizationofcompile;

import java.util.HashMap;
import java.util.Map;

/**
 * 泛型擦除后的例子
 */
public class GenericEarse {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("hello", "你好");
        map.put("how are you?", "吃了没？");
        System.out.println((String) map.get("hello"));
        System.out.println((String) map.get("how are you?"));
    }
}