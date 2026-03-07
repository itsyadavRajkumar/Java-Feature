package com.java.leetcode;

public class SearchInRotatedSortedArrayII {
    int helper(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high && nums[low + 1] == nums[low]) low++;
        while (low < high && nums[high] == nums[high - 1]) high--;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    boolean binarySearch(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return true;
            else if (nums[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }

    public boolean search(int[] nums, int target) {
        int idx = helper(nums);
        return binarySearch(nums, target, 0, idx - 1)
                || binarySearch(nums, target, idx, nums.length - 1);
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArrayII ob = new SearchInRotatedSortedArrayII();
        int[] nums = {1, 1, 1, 1, 0, 1};
        int target = 0;
        System.out.println(ob.search(nums, target));
    }
}
