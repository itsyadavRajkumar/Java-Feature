package com.java.stream;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyOfCharacter {
    public static void main(String[] args) {
        String str = "helloworlds";
        str
                .chars()
                .mapToObj(x -> (char) x)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
//                .sorted(Map.Entry.<Character, Long>comparingByKey().reversed())
                .sorted(Map.Entry.<Character, Long>comparingByValue())
                .forEach(System.out::println);
    }
}
