package com.java.stream;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FreqOfChar {
    public static void main(String[] args) {
        String str = "rajkumar";
        Map<Character, Long> collect = str.chars().
                mapToObj(x -> (char) x).collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));

//        collect.entrySet().forEach(System.out::println);
//
//        System.out.println();
//
//        collect.entrySet().stream().sorted(Map.Entry.<Character, Long>comparingByValue().reversed())
//                .forEach(System.out::println);

//        stringFreq.entrySet().forEach(System.out::println);

//        for (Map.Entry<Character, Long> it:collect.entrySet()) {
//            System.out.println(it.getKey() + " " + it.getValue());
//        }

        String[] strings = {"raj", "ravi", "raj", "kumar", "rajkumar", "kumar"};
        Map<String, Long> stringFreq = Arrays.stream(strings)
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));

        stringFreq.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByKey())
                .forEach(System.out::println);

        Integer[] nums = {12, 12, 2, 1, 2, 1, 2, 4, 33};
        Map<Integer, Long> numFreq = Arrays.stream(nums)
                .collect(Collectors.groupingBy(x->x,
                Collectors.counting()));
        for (Map.Entry<Integer, Long> it:numFreq.entrySet()) {
            System.out.println(it.getKey() + "=" + it.getValue());
        }
    }
}
