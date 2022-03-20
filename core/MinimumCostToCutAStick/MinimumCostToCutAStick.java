package com.dbc;

import java.util.Arrays;

public class MinimumCostToCutAStick {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        Arrays.sort(cuts);
        int[] newCuts = new int[m + 2];
        newCuts[0] = 0;
        for (int i = 1; i <= m; ++i) {
            newCuts[i] = cuts[i - 1];
        }
        newCuts[m + 1] = n;
        int[][] f = new int[m + 2][m + 2];
        for (int i = m; i >= 1; --i) {
            for (int j = i; j <= m; ++j) {
                f[i][j] = i == j ? 0 : Integer.MAX_VALUE;
                for (int k = i; k <= j; ++k) {
                    f[i][j] = Math.min(f[i][j], f[i][k - 1] + f[k + 1][j]);
                }
                f[i][j] += newCuts[j + 1] - newCuts[i - 1];
            }
        }
        return f[1][m];
    }
}
