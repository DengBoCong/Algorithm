package com.dbc;

public class OneAwayLcci {
    public boolean oneEditAway(String first, String second) {
        int[][] dp = new int[first.length() + 1][second.length() + 1];
        for (int i = 0; i < first.length() + 1; i++) dp[i][0] = i;
        for (int i = 0; i < second.length() + 1; i++) dp[0][i] = i;
        for (int i = 1; i < first.length() + 1; i++) {
            for (int j = 1; j < second.length() + 1; j++) {
                int left = dp[i][j - 1] + 1;
                int down = dp[i - 1][j] + 1;
                int leftDown = dp[i - 1][j - 1];
                if (first.charAt(i - 1) != second.charAt(j - 1)) leftDown++;
                dp[i][j] = Math.min(left, Math.min(down, leftDown));
            }
        }
        return dp[first.length()][second.length()] == 0 || dp[first.length()][second.length()] == 1;
    }

    public boolean oneEditAway1(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1) return false;
        if (first.length() < second.length()) return oneEditAway1(second, first);
        for (int i = 0; i < second.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                if (first.length() == second.length()) return first.substring(i + 1).equals(second.substring(i + 1));
                else return first.substring(i + 1).equals(second.substring(i));
            }
        }
        return true;
    }
}
