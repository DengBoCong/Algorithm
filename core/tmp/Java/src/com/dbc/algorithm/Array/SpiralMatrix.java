package com.dbc.algorithm.Array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] direct = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = 0, dir = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < m * n; i++) {
            result.add(matrix[row][col]);
            matrix[row][col] = 1000;
            int nextRow = row + direct[dir][0], nextCol = col + direct[dir][1];
            if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || matrix[nextRow][nextCol] == 1000) {
                dir = (dir + 1) % 4;
            }
            row += direct[dir][0];
            col += direct[dir][1];
        }
        return result;
    }
}
