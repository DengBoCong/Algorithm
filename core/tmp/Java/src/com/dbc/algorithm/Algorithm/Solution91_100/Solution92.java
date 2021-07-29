package com.dbc.leecode.Algorithm.Solution91_100;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-12 14:53
 **/
public class Solution92 {
    public int numDecodingsS1(String s){
        if (s == null || s.length() == 0){
            return 0;
        }
        return digui(s, 0);
    }

    private int digui(String s, int start){
        if (s.length() == start){
            return 1;
        }
        if (s.charAt(start) == '0'){
            return 0;
        }

        int ans1 = digui(s, start + 1);
        int ans2 = 0;
        if (start < s.length() - 1){
            int ten = (s.charAt(start) - '0') * 10;
            int one = (s.charAt(start + 1) - '0');
            if (ten + one <= 26){
                ans2 = digui(s, start + 2);
            }
        }
        return ans1 + ans2;
    }

    public int numDecodings(String s){
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[len] = 1;
        if (s.charAt(len - 1) != '0'){
            dp[len - 1] = 1;
        }
        for (int i = len - 2; i >=0; i--){
            if (s.charAt(i) == '0'){
                continue;
            }
            int ans1 = dp[i + 1];
            int ans2 = 0;
            int ten = (s.charAt(i) - '0') * 10;
            int one = s.charAt(i + 1) - '0';
            if (ten + one <= 26){
                ans2 = dp[i + 2];
            }
            dp[i] = ans1 + ans2;
        }
        return dp[0];
    }
}
