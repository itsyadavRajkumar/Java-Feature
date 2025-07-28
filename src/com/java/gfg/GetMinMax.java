package com.java.gfg;

import java.util.Arrays;

public class GetMinMax {

    static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "(" + key + ", " + value + ")";
        }
    }

    public Pair<Integer, Integer> getMinMax(int[] arr) {
        int max = Arrays.stream(arr).max().orElseThrow();
        int min = Arrays.stream(arr).min().orElseThrow();
        return new Pair<>(min, max); // returning (min, max)
    }

    public static void main(String[] args) {
        GetMinMax finder = new GetMinMax();
        int[] arr = {4, 2, 7, 1, 9, 5};
        Pair<Integer, Integer> result = finder.getMinMax(arr);
        System.out.println("Min and Max: " + result); // Output: (1, 9)
    }
}
