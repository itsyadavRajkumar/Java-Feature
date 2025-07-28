package com.java.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class FindLongestStringInAListOfStrings {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("rajkumar", "yadav", "Azamgarh", "Uttar-Pradesh");
        Optional<String> max = stringList.stream()
                .max((x, y) -> Integer.compare(x.length(), y.length()));

        System.out.println(max.get());


        String maxLenStr = stringList.stream()
                .max(Comparator.comparingInt(String::length)).get();

        System.out.println(maxLenStr);
    }
}
