package com.java.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    static Map<Character, Integer> solve(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        Map<Character, Integer> merge = new HashMap<>();
        for (Map.Entry<Character, Integer> it:map1.entrySet()) {
            Character key = it.getKey();
            Integer val = it.getValue();
            merge.putIfAbsent(key, val + map2.getOrDefault(key, 0));
            map2.remove(key);
        }

        for (Map.Entry<Character, Integer> it:map2.entrySet()) {
            Character key = it.getKey();
            Integer val = it.getValue();
            merge.putIfAbsent(key, val);
        }
        return merge;
    }

    public static void main(String[] args) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        map1.put('a', 2);
        map1.put('b', 2);
        map1.put('c', 1);
        map1.put('f', 1);
        map1.put('e', 1);

        map2.put('a', 1);
        map2.put('b', 3);
        map2.put('c', 1);
        map2.put('d', 5);

//        Map<Character, Integer> collect = Stream.concat(map1.entrySet().stream(), map2.entrySet().stream())
//                .collect(Collectors.toMap(
//                        Map.Entry::getKey,
//                        Map.Entry::getValue,
//                        Integer::sum
//                ));
//
//        System.out.println(collect);

        Map<Character, Integer> solve = solve(map1, map2);
        System.out.println(solve);
    }
}
