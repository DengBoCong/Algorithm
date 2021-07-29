package com.dbc.algorithm.Array;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int[][] direct = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int row = 0, col = 0, dir = 0;
        for (int i = 0; i < n * n; i++) {
            matrix[row][col] = i + 1;
            int nextRow = row + direct[dir][0];
            int nextCol = col + direct[dir][1];
            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || matrix[nextRow][nextCol] != 0) {
                dir = (dir + 1) % 4;
            }
            row += direct[dir][0];
            col += direct[dir][1];
        }
        return matrix;
    }
}
