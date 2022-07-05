package com.dbc.code;

import java.util.Arrays;

public class LongestIncreasingPathInAMatrix {
    private int dfs(int row, int col, int[][] matrix, int[][] memo) {
        if (memo[row][col] != 0) return memo[row][col];
        memo[row][col]++;
        int[][] dirs = new int[][]{{row + 1, col}, {row - 1, col}, {row, col + 1}, {row, col - 1}};
        for (int[] dir : dirs) {
            if (dir[0] >= 0 && dir[0] < matrix.length && dir[1] >= 0 && dir[1] < matrix[0].length && matrix[row][col] < matrix[dir[0]][dir[1]]) {
                memo[row][col] = Math.max(memo[row][col], dfs(dir[0], dir[1], matrix, memo) + 1);
            }
        }
        return memo[row][col];
    }

    public int longestIncreasingPath(int[][] matrix) {
        int res = 0;
        int[][] memo = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                res = Math.max(res, dfs(i, j, matrix, memo));
            }
        }
        return res;
    }
}
