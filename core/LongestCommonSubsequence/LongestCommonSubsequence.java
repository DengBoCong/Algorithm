package com.dbc;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < text1.length(); i++) {
            Arrays.fill(dp[i], 0);
        }
        for (int row = 1; row < text1.length() + 1; row++) {
            for (int col = 1; col < text2.length() + 1; col++) {
                if (text1.charAt(row - 1) == text2.charAt(col - 1)) {
                    dp[row][col] = dp[row - 1][col - 1] + 1;
                } else {
                    dp[row][col] = Math.max(Math.max(dp[row - 1][col], dp[row][col - 1]), dp[row - 1][col - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
