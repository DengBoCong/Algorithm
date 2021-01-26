package com.dbc.algorithm.Daily;

import java.util.HashSet;
import java.util.Set;

public class RegionsCutBySlashes {
    public static int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int[] parent = new int[n * n * 4];
        for (int i = 0; i < n * n * 4; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int idx = i * n + j;
                if (i < n - 1) {
                    int bottom = idx + n;
                    union(parent, idx * 4 + 2, bottom * 4);
                }
                if (j < n - 1) {
                    int right = idx + 1;
                    union(parent, idx * 4 + 1, right * 4 + 3);
                }

                if (grid[i].charAt(j) == '/') {
                    union(parent, idx * 4, idx * 4 + 3);
                    union(parent, idx * 4 + 1, idx * 4 + 2);
                } else if (grid[i].charAt(j) == '\\') {
                    union(parent, idx * 4, idx * 4 + 1);
                    union(parent, idx * 4 + 2, idx * 4 + 3);
                } else {
                    union(parent, idx * 4, idx * 4 + 1);
                    union(parent, idx * 4 + 1, idx * 4 + 2);
                    union(parent, idx * 4 + 2, idx * 4 + 3);
                }
            }
        }

        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < n * n * 4; i++) {
            result.add(find(parent, i));
        }
        return result.size();
    }

    public static int find(int[] parent, int index) {
        if (index != parent[index])
            parent[index] = find(parent, parent[index]);
        return parent[index];
    }

    public static void union(int[] parent, int index1, int index2) {
        parent[find(parent, index2)] = find(parent, index1);
    }
}
