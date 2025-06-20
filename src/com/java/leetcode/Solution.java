package com.java.leetcode;

import java.util.*;

class Solution {

    private boolean solve(StringBuilder s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (!Objects.equals(s.charAt(j), s.charAt(i))) {
                return false;
            }
            i++;
            j--;
        }
        // System.out.println(s.length() + ": " + s);
        return true;
    }

    private String longestPalindromeSolve(String s) {
        int len = s.length();
        StringBuilder res = new StringBuilder();
        int i = 0, k = 1;
        while (i < len) {
            int j = 0, l = 0;
            while (j < len) {
                if (j - l + 1 < k) j++;
                else if (j - l + 1 == k) {
                    StringBuilder str = new StringBuilder(s.substring(l, j + 1));
                    if (solve(str)) res = str;
                    l++;
                    j++;
                }
            }
            k++;
            i++;
        }
        return res.toString();
    }

    private String longestPalindromeDp(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (Objects.equals(s.charAt(i), s.charAt(j))) {
                    if (dp[i + 1][j - 1]) dp[i][j] = true;
                    else dp[i][j] = false;
                }
                System.out.println(i + ": " + s.charAt(i) + " , " + j + ": " + s.charAt(j));
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return "";
    }

    public String longestPalindrome(String s) {
        // return longestPalindromeSolve(s);

        return longestPalindromeDp(s);
    }

    //    combination sum
    private void solve(int i, int[] candidate, int target, List<List<Integer>> res, List<Integer> temp) {
        if (target == 0) {
            res.add(temp);
            return;
        }
        if (i >= candidate.length || target < 0) return;
        temp.add(candidate[i]);
        solve(i, candidate, target - candidate[i], res, temp);
        temp.remove(temp.size() - 1);
        solve(i + 1, candidate, target, res, temp);

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(0, candidates, target, res, temp);
        return res;
    }


    //    30. Substring with Concatenation of All Words
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        int len = words.length;

//        Tries test = new Tries(len);


        return res;
    }
}
