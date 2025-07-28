package com.java.stream;

import java.util.*;

public class HandleNULLValues {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Apple", null, "Banana", null, "Mongo");
        list.stream()
                .map(Optional::ofNullable)
                .forEach(System.out::println);

        list.stream()
                .map(s -> {
                    if (s == null) return "XYZ";
                    else return s.toUpperCase();
                })
                .forEach(System.out::println);

        list.stream()
                .filter(Objects::nonNull)
                .forEach(System.out::println);
    }
}
