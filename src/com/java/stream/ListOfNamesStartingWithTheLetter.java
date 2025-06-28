package com.java.stream;

import java.util.Arrays;
import java.util.List;

public class ListOfNamesStartingWithTheLetter {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("rajkumar", "amit", "rahul", "ravi");
        List<String> stringList = list.stream().filter(s -> s.startsWith("r")).toList();
        stringList.forEach(System.out::println);
    }
}
