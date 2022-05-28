package com.dbc;

import java.util.*;

public class WordBreakII {
    private void dfs(String str, Deque<String> queue, List<String> res, List<String> wordDict) {
        if (str.equals("")) {
            res.add(String.join(" ", queue));
        }
        for (int i = str.length() - 1; i >= 0; i--) {
            String subStr = str.substring(i);
            if (wordDict.contains(subStr)) {
                queue.addFirst(subStr);
                dfs(str.substring(0, i), queue, res, wordDict);
                queue.pollFirst();
            }
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        dfs(s, new ArrayDeque<>(), res, wordDict);
        return res;
    }
}
