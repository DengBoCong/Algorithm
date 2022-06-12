package com.dbc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAndReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (word.length() != pattern.length()) continue;
            Map<Character, Character> map1 = new HashMap<>();
            Map<Character, Character> map2 = new HashMap<>();
            for (int i = 0; i < word.length(); i++) {
                if (!map1.containsKey(word.charAt(i)) && !map2.containsKey(pattern.charAt(i))) {
                    map1.put(word.charAt(i), pattern.charAt(i));
                    map2.put(pattern.charAt(i), word.charAt(i));
                }
                if (map1.getOrDefault(word.charAt(i), '_') != pattern.charAt(i) || map2.getOrDefault(pattern.charAt(i), '_') != word.charAt(i)) break;
                if (i == word.length() - 1) res.add(word);
            }
        }
        return res;
    }
}
