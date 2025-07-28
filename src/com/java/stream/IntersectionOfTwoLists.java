package com.java.stream;

import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoLists {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 5, 6, 8);
        List<Integer> list2 = Arrays.asList(4, 7, 8, 9, 1, 2);
        list1.stream()
                .filter(list2::contains)
                .forEach(System.out::println);
    }
}
