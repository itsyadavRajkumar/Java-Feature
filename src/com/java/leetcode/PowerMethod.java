package com.java.leetcode;

public class PowerMethod {
    public static double myPow(double x, int n) {
        long N = n;
        if (n < 0) {
            x = 1 / x;
            N = -1 * N;
        }
        double res = 1.0000;

        while (N > 0) {
            if ((N & 1) == 1) {
                res *= x;
            }
            x *= x;
            N >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.0000, -2147483648));
        System.out.println(myPow(3.0000, 5));
        System.out.println(myPow(2.0000, 10));
    }
}
