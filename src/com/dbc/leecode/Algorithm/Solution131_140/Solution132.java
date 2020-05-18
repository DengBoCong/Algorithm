package com.dbc.leecode.Algorithm.Solution131_140;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-25 10:53
 **/
public class Solution132 {
    public List<List<String>> partitionS1(String s){
        return partitionHelper(s, 0);
    }

    private List<List<String>> partitionHelper(String s, int start){
        if (start == s.length()){
            List<String> list = new ArrayList<>();
            List<List<String>> ans = new ArrayList<>();
            ans.add(list);
            return ans;
        }
        List<List<String>> ans = new ArrayList<>();
        for (int i = start; i < s.length(); i++){
            if (isPalindrome(s.substring(start, i + 1))){
                String left = s.substring(start, i + 1);
                for (List<String> l : partitionHelper(s, i + 1)){
                    l.add(0, left);
                    ans.add(l);
                }
            }
        }
        return ans;
    }

    private boolean isPalindrome(String s){
        int i = 0;
        int j = s.length() - 1;
        while (i < j){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int length = s.length();
        for (int len = 1; len <= length; len++) {
            for (int i = 0; i <= s.length() - len; i++) {
                dp[i][i + len - 1] = s.charAt(i) == s.charAt(i + len - 1) && (len < 3 || dp[i + 1][i + len - 2]);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        partitionHelper(s, 0, dp, new ArrayList<>(), ans);
        return ans;
    }

    private void partitionHelper(String s, int start, boolean[][] dp, List<String> temp, List<List<String>> res) {
        //到了空串就加到最终的结果中
        if (start == s.length()) {
            res.add(new ArrayList<>(temp));
        }
        //在不同位置切割
        for (int i = start; i < s.length(); i++) {
            //如果是回文串就加到结果中
            if (dp[start][i]) {
                String left = s.substring(start, i + 1);
                temp.add(left);
                partitionHelper(s, i + 1, dp, temp, res);
                temp.remove(temp.size() - 1);
            }

        }
    }
}
