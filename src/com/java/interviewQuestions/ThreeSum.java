package com.java.interviewQuestions;

import java.util.*;

public class ThreeSum {
    /*
    Given a string s, find the first non-repeating character in it and return its index.
    If it does not exist, return -1.

Input: s = "leetcode"

Output: 0

l = 1
e = 3
t = 1
c = 1
o = 1

     */

    public static int solve(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); ++i) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    /*
    Given an integer array nums, return all the
    triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k,
    and nums[i] + nums[j] + nums[k] == 0.
the solution set must not contain duplicate triplets.

Input: nums = [-1,0,1,2,-1,-4] = -4 -1 -1 0 1 5
Output: [[-1,-1,2],[-1,0,1]]
-4 -1 5
-4 -1 5
-4 -1 + 2
     */

    public static List<List<Integer>> solve1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
//        String s = "aabb";
//        System.out.println(solve(s));


//        int n = 5;
//        int []nums = new int[n];
//        for (int i = 0; i < n; ++i) {
//            Scanner sc = new Scanner(System.in);
//            int val = sc.nextInt();
//            nums[i] = val;
//        }
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = solve1(nums);
        System.out.println(lists);
    }
}
