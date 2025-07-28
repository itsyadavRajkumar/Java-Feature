package com.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ImplementAMethodToPartitionAListIntoTwoGroupsBasedOnAPredicate {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<Boolean, List<Integer>> listMap = list.stream()
                .collect(Collectors.partitioningBy(x -> x % 2 == 0));

//        listMap.entrySet().forEach(System.out::println);

        List<Integer> evenList = listMap.get(true);
        List<Integer> oddList = listMap.get(false);

        evenList.forEach(System.out::println);
        System.out.println("---------------------");
        oddList.forEach(System.out::println);
    }
}
