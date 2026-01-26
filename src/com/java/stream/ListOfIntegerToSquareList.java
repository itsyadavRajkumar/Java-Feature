package com.java.stream;

import java.util.List;

public class ListOfIntegerToSquareList {
    /*
    Convert a List<Integer> into a list of squares of even numbers only using streams.
     */
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);

        List<Integer> square = nums.stream()
                .filter(x -> x % 2 != 0)
                .map(x -> x * 2)
                .toList();

        square.forEach(System.out::println);
    }
}
