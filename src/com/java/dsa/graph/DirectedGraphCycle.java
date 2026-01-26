//package com.java.dsa.graph;
//
//import java.util.*;
//
//public class DirectedGraphCycle {
//    public boolean isCyclic(int V, int[][] edges) {
//        // code here
////        firstly needs to covert to this in adjacency list
//        Map<Integer, List<Integer>> adj = new HashMap<>(V);
//        for (int i = 0; i < V; ++i) {
//            adj.put(i, new ArrayList<>());
//        }
//        for (int[] edge:edges) {
//            int u = edge[0];
//            int v = edge[1];
//            adj.putIfAbsent(u, new ArrayList<>());
//            adj.get(u).add(v);
//        }
//        return usingDfs(V, adj);
//    }
//
//    private boolean usingDfs(int V, Map<Integer, List<Integer>> adj) {
//        boolean[] vis = new boolean[V];
//        boolean[] cyclePath = new boolean[V];
//        for (int i = 0; i < V; i++) {
//            if (!vis[i]) {
//                if (dfs(adj, vis, cyclePath, i)) return true;
//            }
//        }
//        return false;
//    }
//
//    private boolean dfs(Map<Integer, List<Integer>> adj, boolean[] vis, boolean[] cyclePath, int node) {
//        vis[node] = cyclePath[node] = true;
//        for (int neighbour:adj.getOrDefault(node, new ArrayList<>())) {
//            if (!vis[neighbour]) {
//                if (dfs(adj, vis, cyclePath, neighbour)) return true;
//            } else if (cyclePath[neighbour]) {
//                return true;
//            }
//        }
//        cyclePath[node] = false;
//        return false;
//    }
//
//    private boolean usingBfs(int V, Map<Integer, List<Integer>> adj) {
//        Queue<Integer> queue = new LinkedList<>();
//        queue
//    }
//}
