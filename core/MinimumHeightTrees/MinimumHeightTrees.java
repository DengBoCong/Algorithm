package com.dbc;

import java.util.*;

public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return new ArrayList<Integer>(){{add(0);}};

        int[] edg = new int[n];
        Arrays.fill(edg, 0);
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
            edg[edge[0]]++;
            edg[edge[1]]++;
        }

        List<Integer> queue = new ArrayList<>();
        for (int i = 0; i < edg.length; i++) {
            if (edg[i] == 1) queue.add(i);
        }
        while (n > 2) {
            n -= queue.size();
            List<Integer> temp = queue;
            queue = new ArrayList<>();
            for (int pos : temp) {
                for (int node : graph[pos]) {
                    edg[node]--;
                    if (edg[node] == 1) {
                        queue.add(node);
                    }
                }
            }
        }
        return queue;
    }
}
