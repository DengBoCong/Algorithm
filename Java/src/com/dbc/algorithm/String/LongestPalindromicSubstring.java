package com.dbc.algorithm.String;

public class LongestPalindromicSubstring {
    public static void expand(String s, int left, int right, int[] remain) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        remain[0] = left + 1;
        remain[1] = right - 1;
    }

    public static String longestPalindrome(String s) {
        int start = 0, end = 0;
        int[] remain = new int[2];
        for (int i = 0; i < s.length(); i++) {
            expand(s, i, i, remain);
            if (remain[1] - remain[0] > end - start) {
                start = remain[0];
                end = remain[1];
            }
            expand(s, i, i + 1, remain);
            if (remain[1] - remain[0] > end - start) {
                start = remain[0];
                end = remain[1];
            }
        }
        return s.substring(start, end + 1);
    }

    public static String preProcess(String s) {
        int n = s.length();
        if (n == 0) {
            return "^$";
        }
        String ret = "^";
        for (int i = 0; i < n; i++) {
            ret += "#" + s.charAt(i);
        }
        ret += "#$";
        return ret;
    }

    public static String longestPalindromeManacher(String s) {
        String T = preProcess(s);
        int n = T.length();
        int[] P = new int[n];
        int C = 0, R = 0;
        for (int i = 1; i < n - 1; i++) {
            int i_mirror = 2 * C - i;
            if (R > i) {
                P[i] = Math.min(R - i, P[i_mirror]);
            }else {
                P[i] = 0;
            }

            while (T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i])) {
                P[i]++;
            }
            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }
        }
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }
        int start = (centerIndex - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }
}
