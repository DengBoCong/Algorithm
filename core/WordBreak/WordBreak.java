package com.dbc;

import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        Arrays.fill(dp, false);
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                if (wordDict.contains(s.substring(j, i + 1)) && (j == 0 || dp[j - 1])) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length() - 1];
    }
}
