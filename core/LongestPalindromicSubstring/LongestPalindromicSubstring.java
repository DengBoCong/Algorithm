package com.dbc;

public class LongestPalindromicSubstring {
    public String calSubString(int left, int right, String s) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public String longestPalindrome(String s) {
        String res = s.substring(0, 1);
        for (int i = 0; i < s.length() - 1; i++) {
            if (i + 1 < s.length()) {
                String subStr = calSubString(i, i + 1, s);
                res = subStr.length() > res.length() ? subStr : res;
            }
            if (i + 2 < s.length()) {
                String subStr = calSubString(i, i + 2, s);
                res = subStr.length() > res.length() ? subStr : res;
            }
        }
        return res;
    }
}
