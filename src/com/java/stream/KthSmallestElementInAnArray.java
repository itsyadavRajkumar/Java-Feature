package com.java.stream;

import java.util.Arrays;
import java.util.List;

public class KthSmallestElementInAnArray {
    public static void main(String[] args) {
        int[] array = {4, 2, 7, 1, 5, 3, 6};
        int k = 9;
//        List<Integer> kSmallest = Arrays.stream(array)
//                .boxed()
//                .sorted()
//                .skip(k)
//                .limit(1).toList();


        int kSmallest = Arrays.stream(array)
                .sorted()
                .skip(k - 1)
                .findFirst()
                .orElse(-1);

        System.out.println(kSmallest);
    }
}
