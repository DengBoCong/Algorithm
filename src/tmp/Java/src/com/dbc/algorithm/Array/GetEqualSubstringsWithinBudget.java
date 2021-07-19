package com.dbc.algorithm.Array;

public class GetEqualSubstringsWithinBudget {
    public static int equalSubstring(String s, String t, int maxCost) {
        int result = 0, left = 0, right = 0, sum = 0;
        while (right < s.length()) {
            sum += Math.abs(s.charAt(right) - t.charAt(right));
            if (sum <= maxCost) {
                result = Math.max(result, right - left + 1);
            } else {
                sum -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            right++;
        }
        return result;
    }
}
