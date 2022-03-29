package com.dbc;

public class NumberOfIslands {
    private void dfs(int row, int col, char[][] grid) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') return;
        grid[row][col] = '0';
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : dirs) {
            dfs(row + dir[0], col + dir[1], grid);
        }
    }

    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int res = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1') {
                    res++;
                    dfs(row, col, grid);
                }
            }
        }
        return res;
    }
}
