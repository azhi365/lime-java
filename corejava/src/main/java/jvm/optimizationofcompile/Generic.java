package jvm.optimizationofcompile;

import java.util.HashMap;
import java.util.Map;

/**
 * 泛型擦除前的例子
 */
public class Generic{
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("hello", "你好");
        map.put("how are you?", "吃了没？");
        System.out.println(map.get("hello"));
        System.out.println(map.get("how are you?"));
    }

}