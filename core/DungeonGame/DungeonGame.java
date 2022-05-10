package com.dbc;

import java.util.Arrays;

public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length, cols = dungeon[0].length;
        int[][] dp = new int[rows + 1][cols + 1];
        for (int i = 0; i <= rows; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[rows][cols - 1] = dp[rows - 1][cols] = 1;
        for (int row = rows - 1; row >= 0; row--) {
            for (int col = cols - 1; col >=0; col--) {
                int min = Math.min(dp[row + 1][col], dp[row][col + 1]);
                dp[row][col] = Math.max(min - dungeon[row][col], 1);
            }
        }
        return dp[0][0];
    }
}
