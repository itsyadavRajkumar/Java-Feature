package com.java.leetcode;

import java.util.Scanner;

public class RemoveZerosInDecimalRepresentation {
    public long removeZeros(long n) {
        StringBuilder res = new StringBuilder();
        while (n > 0) {
            long rem = n % 10;
            if (rem != 0) res.append(rem);
            n /= 10;
        }
        return Long.parseLong(res.reverse().toString());
    }

    public static void main(String[] args) {
        RemoveZerosInDecimalRepresentation ob = new RemoveZerosInDecimalRepresentation();
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        System.out.println(ob.removeZeros(n));
    }
}
