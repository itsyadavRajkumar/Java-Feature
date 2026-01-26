package com.java.stream;

import java.util.List;

public class ListStartWithVowel {
    /*
    Count how many strings in a list start with a vowel.
     */
    public static void main(String[] args) {
        List<String> list = List.of("rajkumar", "abhishek", "elephant", "yadav");
        list.stream()
                .filter(x-> x.charAt(0) == 'a' || x.charAt(0) == 'e' || x.charAt(0) == 'i'
                        || x.charAt(0) == 'o' || x.charAt(0) == 'u')
                .toList().forEach(System.out::println);
    }
}
