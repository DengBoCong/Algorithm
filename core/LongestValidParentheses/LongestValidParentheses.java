package com.dbc;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.substring(i - 1, i + 1).equals("()")) {
                dp[i] = i - 1 > 0 ? dp[i - 2] + 2 : 2;
            } else if (s.substring(i - 1, i + 1).equals("))") && i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                dp[i] = i - dp[i - 1] - 1 > 0 ? dp[i - dp[i - 1] - 2] : 0;
                dp[i] += dp[i - 1] + 2;
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
