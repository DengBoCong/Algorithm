package com.dbc.algorithm.Pointer;

public class LongestRepeatingCharacterReplacement {
    public static int characterReplacement(String s, int k) {
        int[] nums = new int[26];
        int left = 0, right = 0, max = 0;
        while (right < s.length()) {
            nums[s.charAt(right) - 'A'] +=1;
            max = Math.max(max, nums[s.charAt(right) - 'A']);
            if (right - left + 1 - max > k) {
                nums[s.charAt(left) - 'A'] -= 1;
                left++;
            }
            right++;
        }

        return right - left;
    }
}
