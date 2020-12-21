package com.dbc.leecode.Algorithm.Solution61_70;

import java.util.Arrays;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-02 19:03
 **/
public class Solution63 {
    public int uniquePathsS1(int m, int n){
        int[][] dp = new int[m][n];
        for(int i = 0; i < n; i++) dp[0][i] = 1;
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePathsS2(int m, int n){
        int[] cur = new int[n];
        Arrays.fill(cur, 1);
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                cur[j] += cur[j - 1];
            }
        }
        return cur[n - 1];
    }

    public int uniquePaths(int m, int n){
        int N = n + m - 2;
        int k = m - 1;
        long res = 1;
        for (int i = 1; i <= k; i++){
            res = res * (N - k + i) / i;
        }
        return (int) res;
    }
}
