package com.dbc;

import java.util.Arrays;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0 || word2.length() == 0) return Math.max(word1.length(), word2.length());
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length() + 1; i++) dp[i][0] = i;
        for (int i = 0; i < word2.length() + 1; i++) dp[0][i] = i;
        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                int left = dp[i][j - 1] + 1;
                int down = dp[i - 1][j] + 1;
                int left_down = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) left_down++;
                dp[i][j] = Math.min(left, Math.min(left_down, down));
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
