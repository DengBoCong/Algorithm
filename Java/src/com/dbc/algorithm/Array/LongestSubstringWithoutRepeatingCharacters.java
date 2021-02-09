package com.dbc.algorithm.Array;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int result = 0, left = 0;
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (count.getOrDefault(s.charAt(i), 0) == 0) {
                result = Math.max(result, i - left + 1);
            }
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);
            while (count.get(s.charAt(i)) > 1) {
                count.put(s.charAt(left), count.get(s.charAt(left)) - 1);
                left++;
            }
        }

        return result;
    }
}
