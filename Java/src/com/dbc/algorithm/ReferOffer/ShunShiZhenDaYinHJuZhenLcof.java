package com.dbc.algorithm.ReferOffer;

public class ShunShiZhenDaYinHJuZhenLcof {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[]{};
        if (matrix[0].length == 0) return new int[]{};

        int[] res = new int[matrix.length * matrix[0].length];
        int row = 0, col = 0, flag = 0;
        int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < matrix.length * matrix[0].length; i++) {
            res[i] = matrix[row][col];
            matrix[row][col] = Integer.MAX_VALUE;
            int nex_row = row + dir[flag][0], next_col = col + dir[flag][1];
            if (nex_row < 0 || nex_row >= matrix.length || next_col < 0 || next_col >= matrix[0].length || matrix[nex_row][next_col] == Integer.MAX_VALUE) {
                flag = (flag + 1) % 4;
            }
            row += dir[flag][0];
            col += dir[flag][1];
        }
        return res;
    }
}
