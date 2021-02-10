package com.dbc.algorithm.Array;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    public static boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> count1 = new HashMap<>();
        Map<Character, Integer> count2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            count1.put(s1.charAt(i), count1.getOrDefault(s1.charAt(i), 0) + 1);
        }

        int left = 0;
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            if (count1.getOrDefault(ch, 0) == 0) {
                left = i + 1;
                count2.clear();
                continue;
            }
            count2.put(ch, count2.getOrDefault(ch, 0) + 1);
            while (count1.get(ch) < count2.get(ch)) {
                count2.put(s2.charAt(left), count2.get(s2.charAt(left)) - 1);
                left++;
            }
            if (i - left + 1 == s1.length()) {
                return true;
            }
        }
        return false;
    }
}
