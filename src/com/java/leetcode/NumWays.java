package com.java.leetcode;

public class NumWays {

    public int numWays(String s) {
        int n = s.length();
        int one = 0;
        long MOD = 1000000007;
        for (char c: s.toCharArray()) {
            one += c - '0';
        }
        if (one == 0) {
            return (int)((((n - 1) * (n - 2)) / 2) % MOD);
        }
        if (one % 3 == 1) return 0;
        int thirdOne = one / 3;
        one = 0;
        int oneWay = 0;
        int twoWay = 0;
        for (char c:s.toCharArray()) {
            one += c - '0';
            if (thirdOne == one) oneWay++;
            else if (thirdOne == 2 * one) twoWay++;
        }
        return (int)((oneWay * twoWay) % MOD);
    }

    public static void main(String[] args) {

    }
}
