package com.java.leetcode;

public class SearchInRotateArray {
    //    int helper(int[] nums) {
//        int n = nums.length;
//        int low = 1, high = n - 2;
//        if (nums[0] < nums[n - 1]) return n - 1;
//        while (low <= high) {
//            int mid = low + (high - low) / 2;
//            if (nums[mid - 1] > nums[mid] && nums[mid] < nums[mid + 1]) return mid - 1;
//            else if (nums[mid - 1] < nums[mid] && nums[n - 1] > nums[mid]) high = mid - 1;
//            else low = mid + 1;
//        }
//        return n - 1;
//    }
//
//    int binarySearch(int[] nums, int target, int low, int high) {
//        while (low <= high) {
//            int mid = low + (high - low) / 2;
//            if (nums[mid] == target) {
//                return mid;
//            } else if (nums[mid] > target) {
//                high = mid - 1;
//            } else {
//                low = mid + 1;
//            }
//        }
//        return -1;
//    }
//
//    public int search(int[] nums, int target) {
//        int n = nums.length;
//        if (n == 1) return nums[0] == target ? 0 : -1;
//        else if (n >= 2) {
//            if (nums[0] == target) return 0;
//            else if (nums[n - 1] == target) return n - 1;
//        }
//        int idx = helper(nums);
//        int val = binarySearch(nums, target, 0, idx);
//        if (val != -1) return val;
//        return binarySearch(nums, target, idx + 1, nums.length - 1);
//    }
    int helper(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    int binarySearch(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int idx = helper(nums);
        int val = binarySearch(nums, target, 0, idx - 1);
        if (val != -1) return val;
        return binarySearch(nums, target, idx, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = {14, 5, 6, 7, 8, 11, 12};
        int target = 5;
        SearchInRotateArray ob = new SearchInRotateArray();
        System.out.println(ob.search(nums, target));
    }
}
