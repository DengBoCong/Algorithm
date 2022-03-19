package com.dbc;

public class LongestNiceSubstring {
    public String longestNiceSubstring(String s) {
        int start = 0, maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int lower = 0, upper = 0;
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) <= 90) {
                    lower |= 1 << (s.charAt(j) - 'a');
                } else {
                    upper |= 1 << (s.charAt(j) - 'A');
                }
                if (lower == upper && j - i + 1 > maxLen) {
                    start = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
