package com.java.leetcode;

public class ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length, zero = 0;
        int prod = 1;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                zero++;

            } else prod *= nums[i];
        }
        if (zero > 1) return new int[len];
        for (int i = 0; i < len; i++) {
            if (zero == 1 && nums[i] != 0) {
                nums[i] = 0;
                continue;
            }
            try {
                nums[i] = prod / nums[i];
            } catch (ArithmeticException e) {

            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] res = productExceptSelf(nums);
        for (int num : res) {
            System.out.println(num);
        }
    }
}
