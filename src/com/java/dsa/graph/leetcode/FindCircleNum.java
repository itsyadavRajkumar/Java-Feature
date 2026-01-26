package com.java.dsa.graph.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindCircleNum {
    public void dfs(Map<Integer, List<Integer>> adj, boolean[] vis, int parent) {
        vis[parent] = true;
        System.out.println(parent);
        for (int child : adj.getOrDefault(parent, new ArrayList<>())) {
            if (!vis[child]) {
                dfs(adj, vis, child);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        Map<Integer, List<Integer>> adj = new HashMap<>(V);
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; ++j) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.putIfAbsent(i, new ArrayList<>());
                    adj.get(i).add(j);
                }
            }
        }
        int res = 0;
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                res++;
                vis[i] = true;
                dfs(adj, vis, i);
            }
        }
        return res;
    }
}
