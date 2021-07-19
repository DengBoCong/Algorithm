package com.dbc.algorithm.UnionFindSets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces {

    public static int find(int[] provinces, int row) {
        if (provinces[row] != row)
            provinces[row] = find(provinces, provinces[row]);
        return provinces[row];
    }

    public static void union(int[] provinces, int row, int col) {
        provinces[find(provinces, row)] = find(provinces, col);
    }

    public static int findCircleNum_union_find(int[][] isConnected) {
        int n = isConnected.length;
        int[] provinces = new int[n];
        for (int i = 0; i < n; i++)
            provinces[i] = i;

        int count = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                if (isConnected[i][j] == 1)
                    union(provinces, i, j);

        for (int i = 0; i < n; i++)
            if (provinces[i] == i)
                count++;

        return count;
    }

    public static int findCircleNum_dfs(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, n, i);
                count++;
            }
        }

        return count;
    }

    public static void dfs(int[][] isConnected, boolean[] visited, int n, int i) {
        for (int j = 0; j < n; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, visited, n, j);
            }
        }
    }

    public static int findCircleNum_bfs(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int j = queue.poll();
                    visited[j] = true;
                    for (int k = 0; k < n; k++) {
                        if (isConnected[j][k] == 1 && !visited[k]) {
                            queue.offer(k);
                        }
                    }
                }
                count++;
            }
        }

        return count;
    }
}
