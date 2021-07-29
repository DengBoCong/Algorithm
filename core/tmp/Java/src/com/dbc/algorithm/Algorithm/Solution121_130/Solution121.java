package com.dbc.leecode.Algorithm.Solution121_130;

import java.util.List;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-20 10:53
 **/
public class Solution121 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        int ans = 0;
        dp[0] = triangle.get(0).get(0);
        int temp,prev = 0,cur;// prev为上一行的dp[j-1],cur为上一行的dp[j]
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                temp = triangle.get(i).get(j);
                cur = dp[j];
                if (j == 0) dp[j] = cur + temp;
                else if (j == triangle.get(i).size() -1) dp[j] = prev+temp;
                else dp[j] = Math.min(prev,cur) + temp;
                prev = cur;
            }
        }

        for (int i = 1; i < dp.length; i++) {
            if (dp[ans] > dp[i]) ans = i;
        }
        return dp[ans];
    }
}
