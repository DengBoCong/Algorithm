package com.dbc.algorithm.Pointer;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        Map<Character, Integer> remain = new HashMap<>();
        Map<Character, Integer> store = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char alpha = t.charAt(i);
            store.put(alpha, store.getOrDefault(alpha, 0) + 1);
            remain.put(alpha, 0);
        }

        int left = -1, right = -1, count = 0, min_length = 100000;
        int i = 0, j = 0, length = t.length();
        boolean flag = true;
        while (i <= j && j < s.length()) {
            char iAlpha = s.charAt(i);
            char jAlpha = s.charAt(j);
            int temp = remain.getOrDefault(jAlpha, -1);

            if (flag && temp != -1) {
                remain.put(jAlpha, temp + 1);
                if (temp + 1 <= store.get(jAlpha))
                    count++;
            }

            if (count == length) {
                if (min_length > j - i + 1) {
                    left = i;
                    right = j;
                    min_length = j - i + 1;
                }
                if (remain.getOrDefault(iAlpha, -1) != -1) {
                    remain.put(iAlpha, remain.get(iAlpha) - 1);
                    if (remain.get(iAlpha) < store.get(iAlpha))
                        count--;
                }
                i++;
            }

            if (count == length) {
                flag = false;
            } else {
                j++;
                flag = true;
            }
        }

        if (min_length == 100000)
            return "";
        else {
            return s.substring(left, right + 1);
        }
    }
}
