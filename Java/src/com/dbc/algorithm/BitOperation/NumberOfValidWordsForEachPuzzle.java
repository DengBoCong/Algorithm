package com.dbc.algorithm.BitOperation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfValidWordsForEachPuzzle {
    public static List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> map = new HashMap<>();

        for (String word : words) {
            int mask = 0;
            for (int i = 0; i < word.length(); i++) {
                mask |= (1 << (word.charAt(i) - 'a'));
            }
            map.put(mask, map.getOrDefault(mask, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (String puzzle : puzzles) {
            int mask = 0, total = 0;
            for (int i = 1; i < puzzle.length(); i++) {
                mask |= (1 << (puzzle.charAt(i) - 'a'));
            }

            int subset = mask;
            while (subset != 0) {
                int s = subset | (1 << (puzzle.charAt(0) - 'a'));
                if (map.containsKey(s)) {
                    total += map.get(s);
                }
                subset = (subset - 1) & mask;
            }
            if (map.containsKey((1 << (puzzle.charAt(0) - 'a')))) {
                total += map.get((1 << (puzzle.charAt(0) - 'a')));
            }
            result.add(total);
        }
        return result;
    }
}
