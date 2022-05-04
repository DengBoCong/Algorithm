package com.dbc;

import java.util.Arrays;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int[] dp = new int[matrix[0].length + 1];
        Arrays.fill(dp, 0);
        int res = 0, remain = 0;
        for (int row = 1; row <= matrix.length; row++) {
            for (int col = 1; col <= matrix[0].length; col++) {
                int temp = dp[col];
                if (matrix[row - 1][col - 1] == '0') dp[col] = 0;
                else dp[col] = Math.min(Math.min(dp[col - 1], temp), remain) + 1;
                remain = temp;
                res = Math.max(res, dp[col]);
            }
        }
        return res * res;
    }
}
