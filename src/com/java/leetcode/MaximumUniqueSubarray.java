package com.java.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaximumUniqueSubarray {
    public static int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0, res = Integer.MIN_VALUE;
        int temp = 0;
        while (j < n) {
            if (!map.containsKey(nums[j])) {
                temp += nums[j];
            } else {
                while (i <= j && map.containsKey(nums[i])) {
                    map.put(nums[i], map.get(nums[i]) - 1);
                    temp -= nums[i];
                    if (map.get(nums[i]) == 0) {
                        map.remove(nums[i]);
                    }
                    i++;
                }
            }
            res = Math.max(res, temp);
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            j++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,2,4,5,6};
        System.out.println(maximumUniqueSubarray(nums));
    }
}
