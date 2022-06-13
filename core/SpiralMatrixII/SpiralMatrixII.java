package com.dbc;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int point = 1, row = 0, col = 0, dir = 0;
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (point <= n * n) {
            res[row][col] = point;
            point++;
            int newRow = row + dirs[dir][0], newCol = col + dirs[dir][1];
            if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= n || res[newRow][newCol] != 0) {
                dir = (dir + 1) % 4;
            }
            row += + dirs[dir][0];
            col += dirs[dir][1];
        }
        return res;
    }
}
