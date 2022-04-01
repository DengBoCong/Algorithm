package com.dbc;

import java.util.*;

public class ArrayOfDoubledPairs {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> remain = new ArrayList<>(map.keySet());
        remain.sort((a, b) -> Math.abs(a) - Math.abs(b));

        for (int num : remain) {
            if (map.getOrDefault(num * 2, 0) < map.get(num)) return false;
            map.put(num * 2, map.getOrDefault(num * 2, 0) - map.get(num));
        }
        return true;
    }
}
