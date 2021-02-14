package com.dbc.algorithm.UnionFindSets;

import java.util.HashMap;
import java.util.Map;

public class CouplesHoldingHands {
    public static int find(int[] parent, int index) {
        if (index != parent[index]) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }

    public static void union(int[] parent, int index1, int index2) {
        parent[find(parent, index2)] = find(parent, index1);
    }

    public static int minSwapsCouples(int[] row) {
        int[] tot = new int[row.length / 2];
        for (int i = 0; i < tot.length; i++) {
            tot[i] = i;
        }
        for (int i = 0; i < row.length; i += 2) {
            union(tot, row[i] / 2, row[i + 1] / 2);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tot.length; i++) {
            int parent = find(tot, i);
            map.put(parent, map.getOrDefault(parent, 0) + 1);
        }

        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result += entry.getValue() - 1;
        }

        return result;
    }
}
