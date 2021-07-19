package com.dbc.algorithm.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString {
    public static List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> count1 = new HashMap<>();
        Map<Character, Integer> count2 = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            count1.put(p.charAt(i), count1.getOrDefault(p.charAt(i), 0) + 1);
        }

        int left = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (count1.getOrDefault(ch, 0) == 0) {
                left = i + 1;
                count2.clear();
                continue;
            }
            count2.put(ch, count2.getOrDefault(ch, 0) + 1);
            while (count2.get(ch) > count1.get(ch)) {
                count2.put(s.charAt(left), count2.get(s.charAt(left)) - 1);
                left++;
            }
            if (i - left + 1 == p.length()) {
                result.add(left);
                count2.put(s.charAt(left), count2.get(s.charAt(left)) - 1);
                left++;
            }
        }
        return result;
    }
}
