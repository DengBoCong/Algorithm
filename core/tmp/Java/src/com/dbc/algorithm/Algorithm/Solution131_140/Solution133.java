package com.dbc.leecode.Algorithm.Solution131_140;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-25 11:12
 **/
public class Solution133 {
    public int minCut(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int[] min = new int[s.length()];
        min[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            int temp = Integer.MAX_VALUE;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == s.charAt(i) && (j + 1 > i - 1 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (j == 0) {
                        temp = 0;
                    } else {
                        temp = Math.min(temp, min[j - 1] + 1);
                    }
                }
            }
            min[i] = temp;

        }
        return min[s.length() - 1];

    }
}
