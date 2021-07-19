package com.dbc.algorithm.UnionFindSets;

public class RedundantConnectionII {
    public static int[] findRedundantDirectedConnection(int[][] edges) {
        int[] ancestor = new int[edges.length + 1];
        int[] parent = new int[edges.length + 1];

        for (int i = 0; i <= edges.length; i++) {
            ancestor[i] = i;
            parent[i] = i;
        }

        int conflict = -1;
        int cycle = -1;

        for (int i = 0; i < edges.length; i++) {
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            if (parent[node2] != node2) {
                conflict = i;
            } else {
                parent[node2] = node1;
                if (find(ancestor, node1) == find(ancestor, node2)) {
                    cycle = i;
                } else {
                    union(ancestor, node1, node2);
                }
            }
        }

        if (conflict < 0) {
            return edges[cycle];
        } else {
            if (cycle >= 0)
                edges[conflict][0] = parent[edges[conflict][1]];
            return edges[conflict];
        }
    }

    public static int find(int[] ancestor, int index) {
        if (ancestor[index] != index) {
            ancestor[index] = find(ancestor, ancestor[index]);
        }
        return ancestor[index];
    }

    public static void union(int[] ancestor, int index1, int index2) {
        ancestor[find(ancestor, index1)] = find(ancestor, index2);
    }
}
