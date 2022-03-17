package com.dbc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWordInDictionary {
    public String longestWord(String[] words) {
        Set<String> set = new HashSet<String>(){{
            add("");
        }};
        Arrays.sort(words, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            } else {
                return b.compareTo(a);
            }
        });
        String res = "";
        for (String word : words) {
            String subWord = word.substring(0, word.length() - 1);
            if (set.contains(subWord)) {
                res = word;
                set.add(word);
            }
        }
        return res;
    }
}
