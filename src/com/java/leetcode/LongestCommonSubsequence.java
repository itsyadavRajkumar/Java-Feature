package com.java.leetcode;

import java.util.Arrays;

public class LongestCommonSubsequence {
    private int solveRec(String text1, String text2, int m, int n, int[][] dp) {
        if (m < 0 || n < 0) return 0;
        if (dp[m][n] != -1) return dp[m][n];
        if (text1.charAt(m) == text2.charAt(n)) {
            return dp[m][n] = 1 + solveRec(text1, text2, m - 1, n - 1, dp);
        }
        return dp[m][n] = Math.max(solveRec(text1, text2, m - 1, n, dp), solveRec(text1, text2, m, n - 1, dp));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solveRec(text1, text2, m - 1, n - 1, dp);
    }
}

