package com.dbc.algorithm.String;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int[] dp = new int[text2.length() + 1];
        int result = 0;
        for (int i = 0; i < text1.length(); i++) {
            int front = 0;
            for (int j = 1; j < text2.length() + 1; j++) {
                int temp = dp[j];
                if (text1.charAt(i) == text2.charAt(j - 1)) {
                    dp[j] = front + 1;
                } else {
                    dp[j] = Math.max(dp[j - 1], Math.max(front, dp[j]));
                }
                front = temp;
                result = Math.max(result, dp[j]);
            }
        }
        return result;
    }
}
