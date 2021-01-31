package com.dbc.algorithm.UnionFindSets;

import java.util.HashSet;
import java.util.Set;

public class SimilarStringGroups {
    public static int find(int[] parent, int index) {
        if (index != parent[index]) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }

    public static void union(int[] parent, int index1, int index2) {
        parent[find(parent, index2)] = find(parent, index1);
    }

    public static boolean check(String a, String b) {
        int num = 0;
        if (a.length() != b.length())
            return false;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                num++;
                if (num > 2) return false;
            }
        }

        return num == 0 || num == 2;
    }

    public static int numSimilarGroups(String[] strs) {
        int n = strs.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (check(strs[i], strs[j]))
                    union(parent, i, j);
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(find(parent, i));
        }

        return set.size();
    }
}
