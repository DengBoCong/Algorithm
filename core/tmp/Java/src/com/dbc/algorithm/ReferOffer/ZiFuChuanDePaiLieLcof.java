package com.dbc.algorithm.ReferOffer;

import java.util.*;

public class ZiFuChuanDePaiLieLcof {
    private List<String> result = new LinkedList<>();
    private char[] ans;

    public String[] permutation(String s) {
        ans = s.toCharArray();
        dfs(0);
        return result.toArray(new String[result.size()]);
    }

    public void dfs(int x) {
        if (x == ans.length - 1) {
            result.add(String.valueOf(ans));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = x; i < ans.length; i++) {
            if (set.contains(ans[i])) continue;
            set.add(ans[i]);
            char ch = ans[i];
            ans[i] = ans[x];
            ans[x] = ch;
            dfs(x + 1);
            char ch1 = ans[i];
            ans[i] = ans[x];
            ans[x] = ch1;
        }
    }
}
