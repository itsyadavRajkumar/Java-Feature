package com.java.leetcode;

public class SplitArray {
    public static int splitArray(int[] nums, int k) {
        int max = 0, sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        int left = max, right = sum;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canSplit(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean canSplit(int[] nums, int k, int maxAllowed) {
        int count = 1, currentSum = 0;
        for (int num : nums) {
            currentSum += num;
            if (currentSum > maxAllowed) {
                count++;
                currentSum = num;
            }
        }
        return count <= k;
    }

    public static void main(String[] args) {
        int[] nums = {7, 2, 5, 10, 8};
        int k = 2;
        System.out.println(splitArray(nums, k)); // Output: 18
    }
}
