package com.dbc.leecode.Algorithm.Solution111_120;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-19 10:48
 **/
public class Solution116 {
    public int numDistinct(String s, String t){
        int s_len = s.length();
        int t_len = t.length();
        int[] dp = new int[s_len + 1];
        for (int i = 0; i <= s_len; i++){
            dp[i] = 1;
        }
        for (int t_i = 1; t_i <= t_len; t_i++){
            int pre = dp[0];
            dp[0] = 0;
            for (int s_i = 1; s_i <= s_len; s_i++){
                int temp = dp[s_i];
                if (t.charAt(t_i - 1) == s.charAt(s_i - 1)){
                    dp[s_i] = dp[s_i - 1] + pre;
                }else {
                    dp[s_i] = dp[s_i - 1];
                }
                pre = temp;
            }
        }
        return dp[s_len];
    }
}
