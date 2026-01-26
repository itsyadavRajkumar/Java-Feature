package com.java.leetcode;

import java.util.*;

class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> firstOccur = new HashMap<>();
        firstOccur.put(0, -1);
        int mask = 0, maxLen = 0;

        Map<Integer, Integer> evenId = new HashMap<>();
        Map<Integer, Integer> oddId = new HashMap<>();
        int evenCount = 0, oddCount = 0;

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int bit = 0;
            if (num % 2 == 0) {
                if (!evenId.containsKey(num)) evenId.put(num, evenCount++);
                bit = evenId.get(num);
            } else {
                if (!oddId.containsKey(num)) oddId.put(num, oddCount++);
                bit = oddId.get(num);
            }

            // Update mask
            if (num % 2 == 0) {
                mask ^= (1 << bit);
            } else {
                mask ^= (1 << bit);
            }

            if (firstOccur.containsKey(mask)) {
                maxLen = Math.max(maxLen, i - firstOccur.get(mask));
            } else {
                firstOccur.put(mask, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.longestBalanced(new int[]{2,5,4,3}));        // 4
        System.out.println(sol.longestBalanced(new int[]{3,2,2,5,4}));      // 5
        System.out.println(sol.longestBalanced(new int[]{22,36,22}));       // 0
        System.out.println(sol.longestBalanced(new int[]{1,2,3,2}));        // 3
        System.out.println(sol.longestBalanced(new int[]{1,2,3,4,5,6,7,8}));// 8
    }
}
