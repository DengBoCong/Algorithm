package com.dbc;

public class ZhiShaoYouKgeZhongFuZiFuDeZuiCO6ww {
    private int dfs(String s, int left, int right, int k) {
        int[] cnt = new int[26];
        for (int i = left; i <= right; i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        char split = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0 && cnt[i] < k) {
                split = (char) (i + 'a');
                break;
            }
        }

        if (split == 0) {
            return right - left + 1;
        }

        int i = left, ret = 0;
        while (i <= right) {
            while (i <= right && s.charAt(i) == split) {
                i++;
            }
            if (i > right) {
                break;
            }

            int start = i;
            while (i <= right && s.charAt(i) != split) {
                i++;
            }
            int length = dfs(s, start, i - 1, k);
            ret = Math.max(ret, length);
        }
        return ret;
    }

    public int longestSubstring(String s, int k) {
        return dfs(s, 0, s.length() - 1, k);
    }
}
