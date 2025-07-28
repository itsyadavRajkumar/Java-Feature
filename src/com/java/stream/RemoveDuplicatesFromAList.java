package com.java.stream;

import java.util.Arrays;
import java.util.List;

//Remove duplicates from a list while preserving the order using Java streams

public class RemoveDuplicatesFromAList {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 2, 4, 3, 456, 6, 3, 2, 1);
        list.stream()
                .distinct()
                .toList()
                .forEach(System.out::println);

    }
}
