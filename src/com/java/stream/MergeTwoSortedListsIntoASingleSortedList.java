package com.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MergeTwoSortedListsIntoASingleSortedList {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> list2 = Arrays.asList(2, 4, 6, 8, 10, 12, 14);
        List<Integer> list = Stream.concat(list1.stream(), list2.stream())
                .sorted()
                .toList();
        list.forEach(System.out::print);
    }
}
