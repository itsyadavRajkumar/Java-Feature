package com.java.inheritence;

public class C1 implements A, B1 {

    @Override
    public int add(int x, int y) {
        return x + y;
    }

    @Override
    public int multiply(int x, int y) {
        return x * y;
    }
}
