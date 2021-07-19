package com.dbc.algorithm.Array;

public class ReshapeTheMatrix {
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int col = nums[0].length;
        if (row * col != r * c) {
            return nums;
        }
        int[][] result = new int[r][c];
        for (int i = 0; i < row * col; i++) {
            result[i / c][i % c] = nums[i / col][i % col];
        }
        return result;
    }
}
