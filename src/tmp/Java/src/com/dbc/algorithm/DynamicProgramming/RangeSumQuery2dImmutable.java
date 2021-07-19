package com.dbc.algorithm.DynamicProgramming;

public class RangeSumQuery2dImmutable {
    private int[][] remain;
    public RangeSumQuery2dImmutable(int[][] matrix) {
        if (matrix.length > 0) {
            remain = new int[matrix.length + 1][matrix[0].length + 1];
            for (int i = 1; i < matrix.length + 1; i++) {
                int sum = 0;
                for (int j = 1; j < matrix[0].length + 1; j++) {
                    sum += matrix[i - 1][j - 1];
                    remain[i][j] = sum + remain[i - 1][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return remain[row2 + 1][col2 + 1] - remain[row1][col2 + 1] - remain[row2 + 1][col1] + remain[row1][col1];
    }
}
