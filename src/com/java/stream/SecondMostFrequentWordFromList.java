package com.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SecondMostFrequentWordFromList {
    public static void main(String[] args) {


//        Second Highest Frequency From Given List of words



        List<String> list = Arrays.asList("apple", "banana", "apple", "apple",
                "banana", "Mongo", "banana", "banana",
                "Mongo", "Grapes");

//        apple = 3, banana = 4, mongo = 2, grapes = 1
        Map.Entry<String, Long> secondHighest = list.stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .skip(1)
                .findFirst()
                .get();

        System.out.println(secondHighest.getKey() + ": " + secondHighest.getValue());
    }

}
