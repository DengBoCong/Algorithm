package com.dbc.leecode.Algorithm.Solution161_170;

public class Solution167 {
    public int calculateMinimumHP(int[][] dungeon){
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[] dp = new int[col + 1];

        for (int i = 0; i <= col; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[col - 1] = dungeon[row - 1][col - 1] > 0 ? 1 : -dungeon[row - 1][col - 1] + 1;
        for (int i = row - 1; i >= 0; i--){
            for (int j = col - 1; j >= 0; j--){
                if (i == row - 1 && j == col - 1){
                    continue;
                }
                dp[j] = Math.min(dp[j], dp[j + 1]) - dungeon[i][j];
                if (dp[j] <= 0){
                    dp[j] = 1;
                }
            }
        }
        return dp[0];
    }
}
