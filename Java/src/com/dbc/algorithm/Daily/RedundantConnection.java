package com.dbc.algorithm.Daily;

public class RedundantConnection {
    public static int[] findRedundantConnection(int[][] edges) {
        int[] store = new int[edges.length + 1];
        for (int i = 0; i <= edges.length; i++) {
            store[i] = i;
        }

        for (int[] edge : edges) {
            if (find(store, edge[0]) == find(store, edge[1])) {
                return edge;
            }
            union(store, edge[0], edge[1]);
        }

        return new int[]{};
    }

    public static int find(int[] store, int point) {
        if (store[point] != point) {
            store[point] = find(store, store[point]);
        }
        return store[point];
    }

    public static void union(int[] store, int start, int end) {
        store[find(store, start)] = store[find(store, end)];
    }
}
