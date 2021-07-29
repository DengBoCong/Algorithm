package com.dbc.algorithm.Pointer;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public int dfs(String s, int left, int right, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = left; i <= right; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        char split = ' ';
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0 && entry.getValue() < k) {
                split = entry.getKey();
            }
        }
        if (split == ' ') {
            return right - left + 1;
        }

        int result = 0, flag = left;
        while (left <= right) {
            while (flag <= right && s.charAt(flag) == split) {
                flag++;
            }
            if (flag > right) break;
            int start = flag;
            while (flag <= right && s.charAt(flag) != split) {
                flag++;
            }

            int length = dfs(s, start, flag - 1, k);
            result = Math.max(result, length);
        }
        return result;
    }

    public int longestSubstring(String s, int k) {
        return dfs(s, 0, s.length() - 1, k);
    }
}
