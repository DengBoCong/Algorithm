package com.dbc.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int index = 0;
        while (index <= s.length() - words.length * words[0].length()) {
            Map<String, Integer> tempMap = new HashMap<>(map);
            boolean flag = true;
            for (int point = index; point < index + words.length * words[0].length(); point+=words[0].length()) {
                String sub = s.substring(point, point + words[0].length());
                if (!tempMap.containsKey(sub) || tempMap.get(sub) <= 0) {
                    flag = false;
                    break;
                }
                tempMap.put(sub, tempMap.get(sub) - 1);
            }
            if (flag) {
                res.add(index);
            }
            index++;
        }
        return res;
    }
}
