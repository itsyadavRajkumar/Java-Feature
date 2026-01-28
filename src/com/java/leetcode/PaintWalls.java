package com.java.leetcode;

public class PaintWalls {
    private int solveRec(int[] cost, int[] time, int n) {
        if (n == 0) return 0;
        return Math.min(cost[n - 1] + solveRec(cost, time, n - 1), solveRec(cost, time, n - 1));
    }
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        return solveRec(cost, time, n);
    }
}
