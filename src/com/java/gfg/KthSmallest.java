package com.java.gfg;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallest {
    public static int kthSmallest(int[] arr, int k) {
        // Your code here
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int j : arr) {
            priorityQueue.add(j);
            if (priorityQueue.size() > k) priorityQueue.poll();
        }
        return !priorityQueue.isEmpty() ? priorityQueue.peek() : -1;
    }
}
