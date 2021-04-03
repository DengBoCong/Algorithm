package com.dbc.algorithm.ReferOffer;

import java.util.HashMap;
import java.util.Map;

public class ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, res = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            if (map.getOrDefault(s.charAt(right), 0) != 0) {
                while (map.getOrDefault(s.charAt(right), 0) != 0) {
                    map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                    left++;
                }
            }
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
