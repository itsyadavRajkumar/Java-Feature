package com.java.dsa.graph;

import java.util.*;

public class Graph {

    public static void dfs(Map<Integer, List<Integer>> adj, boolean[] vis, int parent) {
        vis[parent] = true;
        System.out.println(parent);
        for (int child : adj.get(parent)) {
            if (!vis[child]) {
                dfs(adj, vis, child);
            }
        }
    }

    public static void bfs(Map<Integer, List<Integer>> adj, int V) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                queue.add(i);
                vis[i] = true;
                while (!queue.isEmpty()) {
                    int parent = queue.poll();
                    System.out.println(parent);
                    for (int child : adj.getOrDefault(parent, new ArrayList<>())) {
                        if (!vis[child]) {
                            queue.add(child);
                            vis[child] = true;
                        }
                    }
                }
            }
        }
    }

    private boolean isCycle(Map<Integer, List<Integer>> adj, boolean[] vis, boolean[] cycleVis, int parent) {
        vis[parent] = cycleVis[parent] = true;
        for (int child : adj.getOrDefault(parent, new ArrayList<>())) {
            if (vis[child] && cycleVis[child]) {
                return true;
            } else if (!vis[child]) {
                if (isCycle(adj, vis, cycleVis, child)) return true;
            }
        }
        cycleVis[parent] = false;
        return false;
    }

    public boolean isCyclic(int V, int[][] edges) {
        // code here

        Map<Integer, List<Integer>> adj = new HashMap<>(V);
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.putIfAbsent(u, new ArrayList<>());
            adj.get(u).add(v);
        }

        for (int i = 0; i < V; i++) {
            adj.putIfAbsent(i, new ArrayList<>());
        }

        boolean[] vis = new boolean[V + 1];
        boolean[] cycleVis = new boolean[V + 1];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (isCycle(adj, vis, cycleVis, i)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int V = scanner.nextInt();
        int E = scanner.nextInt();
        Map<Integer, List<Integer>> adj = new HashMap<>(V);
        for (int i = 0; i < E; ++i) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adj.putIfAbsent(u, new ArrayList<>());
            adj.get(u).add(v);

//            undirected graph
            adj.putIfAbsent(v, new ArrayList<>());
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[V];
        System.out.println("DFS: ");
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(adj, vis, i);
            }
        }
        System.out.println("BFS: ");
        bfs(adj, V);
    }
}
