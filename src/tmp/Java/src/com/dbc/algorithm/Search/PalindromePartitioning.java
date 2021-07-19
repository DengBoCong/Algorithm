package com.dbc.algorithm.Search;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    private int[][] f;
    private List<List<String>> ret = new ArrayList<>();
    private List<String> ans = new ArrayList<>();
    private int n;

    public List<List<String>> partition(String s) {
        n = s.length();
        f = new int[n][n];
        dfs(s, 0);
        return ret;
    }

    private void dfs(String s, int i) {
        if (i == n) {
            ret.add(new ArrayList<>(ans));
            return;
        }
        for (int j = i; j < n; j++) {
            if (isPalindrome(s, i, j) == 1) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }

    public int isPalindrome(String s, int i, int j) {
        if (f[i][j] != 0) {
            return f[i][j];
        }
        if (i >= j) {
            f[i][j] = 1;
        }else if (s.charAt(i) == s.charAt(j)) {
            f[i][j] = isPalindrome(s, i + 1, j - 1);
        }else {
            f[i][j] = -1;
        }
        return f[i][j];
    }
}
