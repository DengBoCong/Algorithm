package com.dbc.algorithm.UnionFindSets;

public class NumberOfOperationsToMakeNetworkConnected {
    public static int makeConnected(int n, int[][] connections) {
        int count = 0;
        int[] parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int[] connection : connections) {
            if (union(parent, connection[0], connection[1])) {
                n--;
            } else {
                count++;
            }
        }

        return count >= n - 1 ? n - 1 : -1;
    }

    public static int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }

    public static boolean union(int[] parent, int index1, int index2) {
        int rootX = find(parent, index1);
        int rootY = find(parent, index2);
        if (rootX != rootY) {
            parent[find(parent, index2)] = find(parent, index1);
            return true;
        } else {
            return false;
        }
    }
}
