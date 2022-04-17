package com.dbc;

import java.util.*;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> hit = new HashSet<>();
        Map<String, Integer> counter = new HashMap<>();
        for (String temp : banned) hit.add(temp);
        int left = 0, right = 0;
        String res = "";
        while (right < paragraph.length()) {
            while (right < paragraph.length() && Character.isLetter(paragraph.charAt(right))) right++;
            String letter = paragraph.substring(left, right).toLowerCase();
            counter.put(letter, counter.getOrDefault(letter, 0) + 1);
            if (counter.get(letter) > counter.getOrDefault(res, 0) && !hit.contains(letter)) res = letter;
            while (right < paragraph.length() && !Character.isLetter(paragraph.charAt(right))) right++;
            left = right;
        }
        return res;
    }
}
