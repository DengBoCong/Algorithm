package com.dbc.code;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestFibonacciSubsequence {
    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) map.put(arr[i], i);
        int[][] dp = new int[arr.length][arr.length];
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] * 2 <= arr[i]) break;
                if (map.containsKey(arr[i] - arr[j])) {
                    int k = map.get(arr[i] - arr[j]);
                    dp[j][i] = Math.max(dp[k][j] + 1, 3);
                    res = Math.max(res, dp[j][i]);
                }
            }
        }
        return res;
    }
}
