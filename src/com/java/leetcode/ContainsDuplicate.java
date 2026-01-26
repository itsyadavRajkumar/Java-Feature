package com.java.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num:nums) {
            if (map.containsKey(num)) return true;
            else map.put(num, 1);
        }
        return false;
    }
}
