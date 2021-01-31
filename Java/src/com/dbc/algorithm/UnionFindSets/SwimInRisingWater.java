package com.dbc.algorithm.UnionFindSets;

import java.util.*;

public class SwimInRisingWater {
    public static int find(int[] parent, int index) {
        if (index != parent[index]) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }

    public static void union(int[] parent, int index1, int index2) {
        parent[find(parent, index2)] = find(parent, index1);
    }

    public static int swimInWaterUnionFind(int[][] grid) {
        int n = grid.length;
        List<int[]> edges = new LinkedList<>();
        int[] parent = new int[n * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                edges.add(new int[]{grid[i][j], i, j});
                parent[i * n + j] = i * n + j;
            }
        }

        Collections.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int result = 0;
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] edge : edges) {
            result = edge[0];
            for (int[] dir : dirs) {
                int nx = edge[1] + dir[0];
                int ny = edge[2] + dir[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && grid[edge[1]][edge[2]] >= grid[nx][ny]) {
                    union(parent, nx * n + ny, edge[1] * n + edge[2]);
                }
            }
            if (find(parent, 0) == find(parent, (n - 1) * n + n - 1)) {
                break;
            }
        }
        return result;
    }

    public static int swimInWaterBinaryBFS(int[][] grid) {
        int n = grid.length;
        int left = grid[0][0], right = n * n - 1, result = 0;
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (left <= right) {
            int mid = (left + right) / 2;
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{0, 0});
            Map<Integer, Boolean> map = new HashMap<>();
            while (!queue.isEmpty()) {
                int[] point = queue.poll();
                for (int[] dir : dirs) {
                    int nx = point[0] + dir[0];
                    int ny = point[1] + dir[1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && !map.getOrDefault(nx * n + ny, false) && grid[nx][ny] <= mid) {
                        queue.add(new int[]{nx, ny});
                        map.put(nx * n + ny, true);
                    }
                }
            }
            if (map.getOrDefault((n - 1) * n + n - 1, false)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public static void dfs(Map<Integer, Boolean> map, int x, int y, int n, int mid, int[][] grid) {
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && !map.getOrDefault(nx * n + ny, false) && grid[nx][ny] <= mid) {
                map.put(nx * n + ny, true);
                dfs(map, nx, ny, n, mid, grid);
            }
        }
    }

    public static int swimInWaterBinaryDfs(int[][] grid) {
        int n = grid.length;
        int left = grid[0][0], right = n * n - 1, result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            Map<Integer, Boolean> map = new HashMap<>();
            dfs(map, 0, 0, n, mid, grid);
            if (map.getOrDefault((n - 1) * n + n - 1, false)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    public static int swimInWaterDijkstra(int[][] grid) {
        int n = grid.length;
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> grid[o[0]][o[1]]));
        queue.offer(new int[]{0, 0});

        boolean[][] visited = new boolean[n][n];
        int[][] distTo = new int[n][n];
        for (int[] row : distTo) {
            Arrays.fill(row, n * n);
        }
        distTo[0][0] = grid[0][0];

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] front = queue.poll();
            int nx = front[0];
            int ny = front[1];
            if (visited[nx][ny]) {
                continue;
            }

            visited[nx][ny] = true;
            if (nx == n - 1 && ny == n - 1) {
                return distTo[n - 1][n - 1];
            }

            for (int[] dir : directions) {
                int x = nx + dir[0];
                int y = ny + dir[1];
                if (inArea(x, y, n) && !visited[x][y] && Math.max(distTo[nx][ny], grid[x][y]) < distTo[x][y]) {
                    distTo[x][y] = Math.max(distTo[nx][ny], grid[x][y]);
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return -1;
    }

    private static boolean inArea(int x, int y, int n) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
