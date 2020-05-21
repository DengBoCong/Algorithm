package com.dbc.leecode.Algorithm.Solution241_250;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution253 {
    public int numSquaresS1(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }
        return dp[n];
    }

    private static List<Integer> dp = new ArrayList<>();
    public int numSquaresS2(int n) {
        if (dp.size() == 0) dp.add(0);

        if (dp.size() <= n) {
            for (int i = dp.size(); i <= n; i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j * j <= i; j++)
                    min = Math.min(dp.get(i - j * j) + 1, min);
                dp.add(min);
            }
        }
        return dp.get(n);
    }

    public int numSquaresHelper(int n) {
        if (n == 0) return 0;
        int count = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            count = Math.min(numSquaresHelper(n - i * i) + 1, count);
        }

        return count;
    }

    public int numSquares(int n) {
        if (isSquare(n)) {
            return 1;
        }

        int temp = n;
        while (temp % 4 == 0) {
            temp /= 4;
        }
        if (temp % 8 == 7) {
            return 4;
        }

        for (int i = 1; i * i < n; i++) {
            if (isSquare(n - i * i)) {
                return 2;
            }
        }

        return 3;
    }

    private boolean isSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}
