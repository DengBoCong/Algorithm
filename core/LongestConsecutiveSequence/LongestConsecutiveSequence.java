package com.dbc;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        int res = 0;
        for (int num : nums) map.put(num, false);
        for (int num : nums) {
            if (!map.get(num)) {
                int start = num - 1, end = num + 1;
                while (map.containsKey(start)) {
                    map.put(start, true);
                    start--;
                }
                while (map.containsKey(end)) {
                    map.put(end, true);
                    end++;
                }
                map.put(num, true);
                res = Math.max(res, end - start - 1);
            }
        }
        return res;
    }
}
