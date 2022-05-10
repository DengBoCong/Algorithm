package com.dbc;

import java.util.Arrays;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length, cols = obstacleGrid[0].length;
        int[] dp = new int[cols + 1];
        Arrays.fill(dp, 0);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (row == 0 && col == 0 && obstacleGrid[0][0] != 1) {
                    dp[col + 1] = 1;
                } else if (obstacleGrid[row][col] == 1) {
                    dp[col + 1] = 0;
                } else {
                    dp[col + 1] = dp[col + 1] + dp[col];
                }
            }
        }
        return dp[cols];
    }
}
