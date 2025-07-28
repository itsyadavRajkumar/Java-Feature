package com.java.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class TwoCitySchedCost {
    public int twoCitySchedCost(int[][] costs) {
        List<int[]> list = Arrays.stream(costs)
                .sorted(Comparator.comparingInt(x -> x[0] - x[1]))
                .toList();
        return IntStream.range(0, costs.length)
                .map(n -> n < costs.length / 2 ? list.get(n)[0] : list.get(n)[1])
                .sum();
    }

    public static void main(String[] args) {

    }
}
