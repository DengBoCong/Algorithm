package com.dbc;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> sCounter = new HashMap<>();
        Map<Character, Integer> tCounter = new HashMap<>();
        for (int i = 0; i < t.length(); i++) tCounter.put(t.charAt(i), tCounter.getOrDefault(t.charAt(i), 0) + 1);
        int sTotal = 0, tTotal = t.length();
        int left = 0, right = 0;
        String res = "";
        while (right < s.length()) {
            while (right < s.length() && sTotal < tTotal) {
                if (sCounter.getOrDefault(s.charAt(right), 0) < tCounter.getOrDefault(s.charAt(right), 0)) sTotal++;
                if (tCounter.getOrDefault(s.charAt(right), 0) > 0) sCounter.put(s.charAt(right), sCounter.getOrDefault(s.charAt(right), 0) + 1);
                right++;
            }
            while (left < right && sTotal == tTotal && (tCounter.getOrDefault(s.charAt(left), 0) == 0 || sCounter.getOrDefault(s.charAt(left), 0) > tCounter.getOrDefault(s.charAt(left), 0))) {
                if (sCounter.getOrDefault(s.charAt(left), 0) > tCounter.getOrDefault(s.charAt(left), 0)) sCounter.put(s.charAt(left), sCounter.get(s.charAt(left)) - 1);
                left++;
            }
            if (sTotal == tTotal && (res.equals("") || res.length() > right - left)) res = s.substring(left, right);
            sCounter.put(s.charAt(left), sCounter.getOrDefault(s.charAt(left), 0) - 1);
            left++;
            sTotal--;
        }
        return res;
    }
}
