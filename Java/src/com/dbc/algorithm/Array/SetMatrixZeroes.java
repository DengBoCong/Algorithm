package com.dbc.algorithm.Array;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        boolean remain_row = false, remain_col = false;
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                remain_row = true;
                break;
            }
        }

        for (int i = 0; i < col; i++) {
            if (matrix[0][i] == 0) {
                remain_col = true;
                break;
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (remain_row) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }

        if (remain_col) {
            for (int i = 0; i < col; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}
