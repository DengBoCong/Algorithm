package com.dbc.algorithm.Math;

public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String remain = x + "";
        int left = 0, right = remain.length() - 1;
        while (left < right) {
            if (remain.charAt(left) != remain.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
