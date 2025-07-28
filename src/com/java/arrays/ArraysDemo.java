package com.java.arrays;

import java.util.Arrays;
import java.util.List;

public class ArraysDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 32, 1, 23, 4, 5);
        System.out.println("before: " + list);
        list.sort((a, b) -> b - a);
        System.out.println("after: " + list);
    }
}
