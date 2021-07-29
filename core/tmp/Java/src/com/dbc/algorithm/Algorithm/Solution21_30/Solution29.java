package com.dbc.leecode.Algorithm.Solution21_30;

public class Solution29 {
    public static int strStr(String haystack, String needle) {
        if (needle.equals("")) return 0;
        int len = needle.length();
        for (int i = 0; i < haystack.length(); i++) {
            if(i + len > haystack.length()) return -1;
            if(haystack.substring(i, i+len).equals(needle)) return i;
        }
        return -1;
    }
}
