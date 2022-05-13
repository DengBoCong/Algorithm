package com.dbc;

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    for (int[] dir : dirs) {
                        int new_row = dir[0] + row;
                        int new_col = dir[1] + col;
                        if (!(new_row >= 0 && new_row < grid.length && new_col >= 0 && new_col < grid[0].length && grid[new_row][new_col] == 1)) {
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }
}
