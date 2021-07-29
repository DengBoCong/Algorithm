package com.dbc.algorithm.UnionFindSets;

import java.util.ArrayList;
import java.util.List;

public class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable {
    public static int find(int[] parent, int index) {
        if (index != parent[index]) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }

    public static void union(int[] parent, int index1, int index2) {
        parent[find(parent, index2)] = find(parent, index1);
    }

    public static int maxNumEdgesToRemove(int n, int[][] edges) {
        int[] parent = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }

        int count = 0;
        int flag = 0;

        List<int[]> alice = new ArrayList<>();
        List<int[]> bob = new ArrayList<>();
        for (int[] edge : edges) {
            if (edge[0] == 1)
                alice.add(edge);
            else if (edge[0] == 2)
                bob.add(edge);
            else {
                int u = find(parent, edge[1]);
                int v = find(parent, edge[2]);
                if (u == v)
                    count++;
                else {
                    flag++;
                    union(parent, edge[1], edge[2]);
                }
            }
        }

        int temp = flag;
        int[] alice_parent = parent.clone();
        int[] bob_parent = parent.clone();
        for (int[] edge : alice) {
            int u = find(alice_parent, edge[1]);
            int v = find(alice_parent, edge[2]);
            if (u == v)
                count++;
            else {
                temp++;
                union(alice_parent, edge[1], edge[2]);
            }
        }

        if (temp < n - 1)
            return -1;
        temp = flag;
        for (int[] edge : bob) {
            int u = find(bob_parent, edge[1]);
            int v = find(bob_parent, edge[2]);
            if (u == v)
                count++;
            else {
                temp++;
                union(bob_parent, edge[1], edge[2]);
            }
        }

        if (temp < n - 1)
            return -1;
        return count;
    }
}
