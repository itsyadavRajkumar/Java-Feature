package com.java.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindLHS {
    public static int findLHS(int[] nums) {
//        TC = O(n*logn)
//        SC = O(n)
        List<Map.Entry<Integer, Long>> list = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>comparingByKey().reversed())
                .toList();

        if (list.size() <= 1) return 0;
        int res = 0, temp = 0;
        for (int i = 1; i < list.size(); i++) {
            int diff = Math.abs(list.get(i - 1).getKey() - list.get(i).getKey());
            temp = (int) (list.get(i - 1).getValue() + list.get(i).getValue());
            if (diff == 1) {
                res = Math.max(res, temp);
            }
        }
        return res;
    }

    public static int findLHS1(int[] nums) {
//        TC = O(n)
//        SC = O(n)
        Map<Integer, Long> list = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        int res = 0;
        for (Map.Entry<Integer, Long> it : list.entrySet()) {
            int key = it.getKey();
            if (list.containsKey(key + 1))
                res = (int) Math.max(res, it.getValue() + list.get(key + 1));
        }
        return res;
    }

    public static int findLHS2(int[] nums) {
//        TC = O(n)
//        SC = O(n)
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num:nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> it : freqMap.entrySet()) {
            int key = it.getKey();
            if (freqMap.containsKey(key + 1))
                res = Math.max(res, it.getValue() + freqMap.get(key + 1));
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
        System.out.println(findLHS(nums));
    }
}

//1 = 1
//2 = 3
//3 = 2
//5 = 1
//7 = 1
