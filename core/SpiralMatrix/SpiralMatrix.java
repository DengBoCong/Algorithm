package com.dbc;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int dir = 0, row = 0, col = 0;
        int rows = matrix.length, cols = matrix[0].length;
        int[][] dirStep = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (row >= 0 && row < rows && col >= 0 && col < cols && matrix[row][col] != 1000) {
            res.add(matrix[row][col]);
            matrix[row][col] = 1000;
            int nextRow = row + dirStep[dir][0], nextCol = col + dirStep[dir][1];
            if (!(nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && matrix[nextRow][nextCol] != 1000)) {
                dir = (dir + 1) % 4;
            }
            row += dirStep[dir][0];
            col += dirStep[dir][1];
        }
        return res;
    }
}
