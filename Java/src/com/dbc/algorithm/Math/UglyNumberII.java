package com.dbc.algorithm.Math;

public class UglyNumberII {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int a2 = 0, a3 = 0, a5 = 0;
        for (int i = 1; i < n; i++) {
            int num2 = dp[a2] * 2;
            int num3 = dp[a3] * 3;
            int num5 = dp[a5] * 5;
            dp[i] = Math.min(num2, Math.min(num3, num5));
            if (dp[i] == num2) a2++;
            if (dp[i] == num3) a3++;
            if (dp[i] == num5) a5++;
        }
        return dp[n - 1];
    }
}
