package jvm.optimizationofcompile;

import java.util.List;

/**
 * 当泛型遇见重载1
 */
public class GenericTypes {

    public static void method(List<String> list) {
        System.out.println("invoke method(List<String> list)");
    }

 /*   public static void method(List<Integer> list) {
        System.out.println("invoke method(List<Integer> list)");
    }*/
}

