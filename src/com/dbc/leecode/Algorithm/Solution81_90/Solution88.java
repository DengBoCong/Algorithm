package com.dbc.leecode.Algorithm.Solution81_90;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-11 11:00
 **/
public class Solution88 {
    public boolean isScrambleS1(String s1, String s2){
        if (s1.length() != s2.length()){
            return false;
        }
        if (s1.equals(s2)){
            return true;
        }

        int[] letters = new int[26];
        for (int i = 0; i < s1.length(); i++){
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++){
            if (letters[i] != 0){
                return false;
            }
        }

        for (int i = 1; i < s1.length(); i++){
            if (isScrambleS1(s1.substring(0, i), s2.substring(0, i)) && isScrambleS1(s1.substring(i), s2.substring(i))){
                return true;
            }

            if (isScrambleS1(s1.substring(0, i), s2.substring(s2.length() - i)) &&
                    isScrambleS1(s1.substring(i), s2.substring(0, s2.length() - i))){
                return true;
            }
        }
        return false;
    }

    public boolean isScramble(String s1, String s2){
        if (s1.length() != s2.length()){
            return false;
        }
        if (s1.equals(s2)){
            return true;
        }

        int[] letters = new int[26];
        for (int i = 0; i < s1.length(); i++){
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++){
            if (letters[i] != 0){
                return false;
            }
        }

        int length = s1.length();
        boolean[][][] dp = new boolean[length + 1][length][length];
        for (int len = 1; len <= length; len++){
            for (int i = 0; i + len <= length; i++){
                for (int j = 0; j + len <= length; j++){
                    if (len == 1){
                        dp[len][i][j] = s1.charAt(i) == s2.charAt(j);
                    }else {
                        for (int q = 1; q < len; q++){
                            dp[len][i][j] = dp[q][i][j] && dp[len - q][i + q][j + q]
                                    || dp[q][i][j + len - q] && dp[len - q][i + q][j];
                            if (dp[len][i][j]){
                                break;
                            }
                        }
                    }
                }
            }
        }
        return dp[length][0][0];
    }
}
