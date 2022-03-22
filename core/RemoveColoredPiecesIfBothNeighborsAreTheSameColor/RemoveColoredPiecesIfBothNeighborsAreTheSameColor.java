package com.dbc;

import java.util.HashMap;
import java.util.Map;

public class RemoveColoredPiecesIfBothNeighborsAreTheSameColor {
    public boolean winnerOfGame(String colors) {
        int left = 0, right = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (left < colors.length() && right < colors.length()) {
            while (right < colors.length() && colors.charAt(left) == colors.charAt(right)) {
                right++;
            }

            int count = right - left >= 3 ? right - left - 2 : 0;
            map.put(colors.charAt(left), map.getOrDefault(colors.charAt(left), 0) + count);
            left = right;
        }
        return map.getOrDefault('A', 0) > map.getOrDefault('B', 0);
    }
}
