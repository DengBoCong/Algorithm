package com.dbc;

import java.util.*;

public class TheTimeWhenTheNetworkBecomesIdle {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        List<Integer>[] graph = new List[patience.length];
        for (int i = 0; i < patience.length; ++i) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        Queue<Integer> queue = new ArrayDeque<Integer>(){{
            add(0);
        }};
        int res = 0, level = 1;
        boolean[] visited = new boolean[patience.length];
        Arrays.fill(visited, false);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int curLen = queue.size();
            for (int i = 0; i < curLen; i++) {
                int curr = queue.poll();
                for (int v : graph[curr]) {
                    if (visited[v]) continue;
                    visited[v] = true;
                    queue.add(v);
                    res = Math.max(res, patience[v] * ((2 * level - 1) / patience[v]) + 2 * level + 1);
                }
            }
            level++;
        }
        return res;
    }
}
