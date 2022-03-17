package com.dbc;

import java.util.List;

public class LongestWordInDictionaryThroughDeleting {
    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        for (String word : dictionary) {
            int left = 0, right = 0;
            while (left < s.length() && right < word.length()) {
                while (left < s.length() && s.charAt(left) != word.charAt(right)) {
                    left++;
                }
                if (left < s.length() && s.charAt(left) == word.charAt(right)) {
                    left++;
                    right++;
                }
            }
            if (right == word.length() && right >= res.length()) {
                res = right > res.length() || word.compareTo(res) < 0 ? word : res;
            }
        }
        return res;
    }
}
