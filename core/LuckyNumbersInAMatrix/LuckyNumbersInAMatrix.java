package com.dbc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LuckyNumbersInAMatrix {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int[] minRow = new int[matrix.length];
        Arrays.fill(minRow, Integer.MAX_VALUE);
        int[] maxCol = new int[matrix[0].length];
        Arrays.fill(maxCol, Integer.MIN_VALUE);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                minRow[i] = Math.min(minRow[i], matrix[i][j]);
                maxCol[j] = Math.max(maxCol[j], matrix[i][j]);
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] <= minRow[i] && matrix[i][j] >= maxCol[j]) {
                    res.add(matrix[i][j]);
                }
            }
        }

        return res;
    }
}
