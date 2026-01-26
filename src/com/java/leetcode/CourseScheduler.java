package com.java.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseScheduler {
    private void dfs(Map<Integer, List<Integer>> adj, boolean[] vis, int node, List<Integer> res) {
        vis[node] = false;
        for (Integer neighbours : adj.getOrDefault(node, new ArrayList<>())) {
            if (!vis[neighbours]) {
                dfs(adj, vis, neighbours, res);
            }
        }
        res.add(node);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < numCourses; ++i) adj.put(i, new ArrayList<>());
        for (int[] node : prerequisites) {
            int u = node[0];
            int v = node[1];
            adj.get(u).add(v);
        }
        int[] res = new int[numCourses];
        List<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[numCourses];
        for (int node = 0; node < numCourses; ++node) {
            if (!vis[node]) {
                dfs(adj, vis, node, ans);
            }
        }
        int i = 0;
        for (Integer num:ans) res[i++] = num;
        return res;
    }

}
