package com.java.gfg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumProvinces {
    static private void dfs(Map<Integer, List<Integer>> list, boolean[] vis, int node) {
        vis[node] = true;
        for (int neighbour : list.getOrDefault(node, new ArrayList<>())) {
            if (!vis[neighbour]) {
                dfs(list, vis, neighbour);
            }
        }
    }

    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        int n = adj.size();
        Map<Integer, List<Integer>> list = new HashMap<>(n);

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i != j && adj.get(i).get(j) == 1) {
                    list.putIfAbsent(i, new ArrayList<>());
                    list.get(i).add(j);
                }
            }
        }
        int cnt = 0;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; ++i) {
            if (!vis[i]) {
                cnt++;
                dfs(list, vis, i);
            }
        }
        return cnt;
    }
}
