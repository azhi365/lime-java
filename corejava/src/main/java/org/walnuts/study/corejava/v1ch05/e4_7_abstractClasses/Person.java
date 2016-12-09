package org.walnuts.study.corejava.v1ch05.e4_7_abstractClasses;

public abstract class Person {
    private String name;

    public Person(String n) {
        name = n;
    }

    public abstract String getDescription();

    public String getName() {
        return name;
    }
}
