package com.java.exception;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

//class Solution {
//    public int[] maxKDistinct(int[] nums, int k) {
//        Set<Integer> set = new HashSet<>();
//        for (int num : nums) {
//            set.add(num);
//        }
//        List<Integer> arr = new ArrayList<>(set);
//        arr.sort((a, b) -> b - a);
//        int n = Math.min(k, arr.size());
//        int[] res = new int[n];
//        for (int i = 0; i < n; i++) {
//            res[i] = arr.get(i);
//        }
//
//        return res;
//    }
//}

//import java.util.*;
//
//class Solution {
//    public boolean[] subsequenceSumAfterCapping(int[] nums, int k) {
//        int n = nums.length;
//        boolean[] answer = new boolean[n];
//        Map<Integer, Integer> countMap = new HashMap<>();
//        for (int num : nums) {
//            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
//        }
//        boolean[] dp = new boolean[k + 1];
//        dp[0] = true;
//        for (int i = 1; i <= n && i <= k; i++) dp[i] = true;
//        if (k <= n) answer[0] = true;
//        for (int x = 2; x <= n; x++) {
//            int count = 0;
//            for (int v : countMap.keySet()) {
//                if (v >= x) count += countMap.get(v);
//            }
//            boolean[] newDp = new boolean[k + 1];
//            for (int sum = 0; sum <= k; sum++) {
//                if (dp[sum]) {
//                    newDp[sum] = true;
//                    for (int add = 1; add <= count && sum + add <= k; add++) {
//                        newDp[sum + add] = true;
//                    }
//                }
//            }
//            dp = newDp;
//            if (dp[k]) answer[x - 1] = true;
//        }
//        return answer;
//    }
//}


import java.util.*;

class Solution {
    public boolean[] subsequenceSumAfterCapping(int[] nums, int k) {
        int n = nums.length;
        boolean[] res = new boolean[n];

        int[] map = new int[n + 2];
        for (int num : nums) {
            if (num <= n) map[num]++;
            else map[n + 1]++;
        }

        boolean[] dp = new boolean[k + 1];
        dp[0] = true;
        for (int i = 1; i <= Math.min(n, k); i++) dp[i] = true;
        if (k <= n) res[0] = true;

        int temp = n;
        for (int x = 2; x <= n; x++) {
            temp -= map[x - 1];
            int cnt = temp;

            boolean[] arr = new boolean[k + 1];
            for (int sum = 0; sum <= k; sum++) {
                if (dp[sum]) {
                    arr[sum] = true;
                    int mx = Math.min(k, sum + cnt);
                    for (int j = sum + 1; j <= mx; j++) {
                        arr[j] = true;
                    }
                }
            }
            dp = arr;
            res[x - 1] = dp[k];
        }
        return res;
    }
}


public class Test {
    public static void main(String[] args) {
        int a = 5;
        int b = 0;
        try {
            System.out.println(a / b);
        } catch (ArithmeticException e) {
            System.out.println(e);
        }
    }
}
