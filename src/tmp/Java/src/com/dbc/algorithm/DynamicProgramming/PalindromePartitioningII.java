package com.dbc.algorithm.DynamicProgramming;

import java.util.Arrays;

public class PalindromePartitioningII {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] remain = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(remain[i], true);
        }
        for (int i = n - 1; i > -1; i--) {
            for (int j = i + 1; j < n; j++) {
                remain[i][j] = (s.charAt(i) == s.charAt(j)) && remain[i + 1][j - 1];
            }
        }

        int[] result = new int[n];
        Arrays.fill(result, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            if (remain[0][i]) {
                result[i] = 0;
            } else {
                for (int j = 0; j < i; j++) {
                    if (remain[j + 1][i]) {
                        result[i] = Math.min(result[i], result[j] + 1);
                    }
                }
            }
        }
        return result[n - 1];
    }
}
