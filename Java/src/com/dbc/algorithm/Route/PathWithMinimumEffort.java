package com.dbc.algorithm.Route;

import java.util.*;

public class PathWithMinimumEffort {
    public static int minimumEffortPathBfs(int[][] heights) {
        int left = 0, right = (int) Math.pow(10, 6) - 1, result = 0;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int row = heights.length, col = heights[0].length;
        Queue<int[]> queue = new LinkedList<>();
        while (left <= right) {
            int[] seen = new int[row * col];
            int mid = (left + right) / 2;
            seen[0] = 1;
            queue.offer(new int[]{0, 0});
            while (!queue.isEmpty()) {
                int[] temp = queue.poll();
                for (int[] dir : dirs) {
                    int nx = temp[0] + dir[0];
                    int ny = temp[1] + dir[1];
                    if (nx >= 0 && nx < row && ny >= 0 && ny < col && seen[nx * col + ny] != 1 && Math.abs(heights[temp[0]][temp[1]] - heights[nx][ny]) <= mid) {
                        seen[nx * col + ny] = 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }

            if (seen[(row - 1) * col + col - 1] == 1) {
                right = mid - 1;
                result = mid;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public static void dfs(int[][] heights, int[] seen, int row, int col, int mid) {
        seen[row * heights[0].length + col] = 1;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : dirs) {
            int nx = dir[0] + row;
            int ny = dir[1] + col;
            if (nx >= 0 && nx < heights.length && ny >= 0 && ny < heights[0].length && seen[nx * heights[0].length + ny] != 1 && Math.abs(heights[row][col] - heights[nx][ny]) <= mid) {
                seen[nx * heights[0].length + ny] = 1;
                dfs(heights, seen, nx, ny, mid);
            }
        }
    }

    public static int minimumEffortPathDfs(int[][] heights) {
        int left = 0, right = (int) Math.pow(10, 6) - 1, result = 0;
        int row = heights.length, col = heights[0].length;

        while (left <= right) {
            int mid = (left + right) / 2;
            int[] seen = new int[row * col];
            seen[0] = 1;
            dfs(heights, seen, 0, 0, mid);

            if (seen[(row - 1) * col + col - 1] == 1) {
                right = mid - 1;
                result = mid;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public static int find(int[] parent, int index) {
        if (index != parent[index]) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }

    public static void union(int[] parent, int index1, int index2) {
        parent[find(parent, index2)] = find(parent, index1);
    }

    public static int minimumEffortPathUnionFind(int[][] heights) {
        List<int[]> edges = new LinkedList<>();
        int row = heights.length, col = heights[0].length;
        int[] parent = new int[row * col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                parent[i * col + j] = i * col + j;
                if (i < row - 1) {
                    edges.add(new int[]{Math.abs(heights[i + 1][j] - heights[i][j]), i * col + j, (i + 1) * col + j});
                }
                if (j < col - 1) {
                    edges.add(new int[]{Math.abs(heights[i][j] - heights[i][j + 1]), i * col + j, i * col + j + 1});
                }
            }
        }

        Collections.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int[] edge : edges) {
            int rootX = find(parent, edge[1]);
            int rootY = find(parent, edge[2]);
            if (rootX != rootY) {
                union(parent, rootX, rootY);
            }
            if (find(parent, 0) == find(parent, (row - 1) * col + col - 1))
                return edge[0];
        }

        return 0;
    }

    public static int minimumEffortPathDijkstra(int[][] heights) {
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = heights.length;
        int n = heights[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        pq.offer(new int[]{0, 0, 0});
        int[] dist = new int[m * n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        boolean[] seen = new boolean[m * n];
        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int x = edge[0], y = edge[1], d = edge[2];
            int id = x * n + y;
            if (seen[id]) {
                continue;
            }
            seen[id] = true;
            for (int i = 0; i < 4; i++) {
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && Math.max(d, Math.abs(heights[nx][ny] - heights[x][y])) < dist[nx * n + ny]) {
                    dist[nx * n + ny] = Math.max(d, Math.abs(heights[x][y] - heights[nx][ny]));
                    pq.offer(new int[]{nx, ny, dist[nx * n + ny]});
                }
            }
        }
        return dist[m * n - 1];
    }
}
