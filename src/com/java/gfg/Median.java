package com.java.gfg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Median {
    public int median(int[][] mat) {
        // code here
        List<Integer> nums = new ArrayList<>();
        int n = mat.length, m = mat[0].length;
        for (int[] num:mat) {
            for (int val:num) {
                nums.add(val);
            }
        }
        Collections.sort(nums);
        return nums.get(nums.size() / 2);
    }
}
