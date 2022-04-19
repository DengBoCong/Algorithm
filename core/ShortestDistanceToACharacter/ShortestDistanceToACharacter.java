package com.dbc;

import java.util.Arrays;

public class ShortestDistanceToACharacter {
    public int[] shortestToChar(String s, char c) {
        int left = 0, right = 1;
        int[] res = new int[s.length()];
        Arrays.fill(res, 0);
        while (right < s.length()) {
            while (right < s.length() && s.charAt(right) != c) {
                if (s.charAt(left) == c) res[right] = Math.abs(right - left);
                right++;
            }
            while (right < s.length() && left < right) {
                if (res[left] != 0) res[left] = Math.min(res[left], Math.abs(right - left));
                else if (s.charAt(left) != c) res[left] = Math.abs(right - left);
                left++;
            }
            right++;
        }
        return res;
    }
}
