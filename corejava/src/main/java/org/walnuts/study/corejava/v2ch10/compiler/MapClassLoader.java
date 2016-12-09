package org.walnuts.study.corejava.v2ch10.compiler;

import java.util.Map;

/**
 * A class loader that loads classes from a map whose keys are class names and whose values are byte
 * code e16_arrays.
 *
 * @author Cay Horstmann
 * @version 1.00 2007-11-02
 */
public class MapClassLoader extends ClassLoader {
    private Map<String, byte[]> classes;

    public MapClassLoader(Map<String, byte[]> classes) {
        this.classes = classes;
    }

    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classBytes = classes.get(name);
        if (classBytes == null)
            throw new ClassNotFoundException(name);
        Class<?> cl = defineClass(name, classBytes, 0, classBytes.length);
        if (cl == null)
            throw new ClassNotFoundException(name);
        return cl;
    }
}