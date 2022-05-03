package com.dbc;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int[][] remain = new int[matrix.length][matrix.length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                remain[row][col] = matrix[row][col];
            }
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                matrix[col][matrix.length - 1 - row] = remain[row][col];
            }
        }
    }
}
