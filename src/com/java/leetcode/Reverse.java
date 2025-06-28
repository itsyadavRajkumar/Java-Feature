package com.java.leetcode;

import java.util.stream.Collectors;

public class Reverse {
    public static int reverse(int x) {
        boolean flag = x < 0;
        x = flag ? x * (-1) : x;
        long num = (long) x;
        long reduce = new StringBuilder(String.valueOf(num))
                .reverse()
                .chars().mapToLong(Character::getNumericValue)
                .reduce(0, (a, b) -> a * 10 + b);
        reduce = flag ? -1 * reduce : reduce;
        if (reduce > Integer.MAX_VALUE || reduce < Integer.MIN_VALUE) return 0;
        return (int)reduce;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }
}
