package com.java.gfg;

import java.util.*;

public class CycleUndirectedGraph {
    static class Pair<K, V> {
        private final K first;
        private final V second;

        public Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }

        public K getFirst() {
            return first;
        }

        public V getSecond() {
            return second;
        }
    }

    private boolean bfs(Map<Integer, List<Integer>> adj, int V) {
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; ++i) {
            if (!vis[i]) {
                Queue<Pair<Integer, Integer>> q = new ArrayDeque<>();
                q.add(new Pair<>(i, -1));
                vis[i] = true;

                while (!q.isEmpty()) {
                    Pair<Integer, Integer> front = q.poll();
                    int node = front.getFirst();
                    int parent = front.getSecond();

                    for (int neighbour : adj.get(node)) {
                        if (!vis[neighbour]) {
                            q.add(new Pair<>(neighbour, node));
                            vis[neighbour] = true;
                        } else if (neighbour != parent) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean isCycle(int V, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < V; i++) adj.put(i, new ArrayList<>());

        for (int[] nums : edges) {
            int u = nums[0], v = nums[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return bfs(adj, V);
    }

}
