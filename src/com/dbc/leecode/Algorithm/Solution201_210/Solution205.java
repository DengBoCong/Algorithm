package com.dbc.leecode.Algorithm.Solution201_210;

public class Solution205 {
    public static String shortestPalindrome(String s) {
        String ss = s + '#' + new StringBuilder(s).reverse();
        int max = getLastNext(ss);
        return new StringBuilder(s.substring(max)).reverse() + s;
    }

    public static int getLastNext(String s) {
        int n = s.length();
        char[] c = s.toCharArray();
        int[] next = new int[n + 1];
        next[0] = -1;
        next[1] = 0;
        int k = 0;
        int i = 2;
        while (i <= n) {
            if (k == -1 || c[i - 1] == c[k]) {
                next[i] = k + 1;
                k++;
                i++;
            } else {
                k = next[k];
            }
        }
        return next[n];
    }
}
