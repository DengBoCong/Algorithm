package com.dbc.code;

import java.util.Locale;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        s = s.toLowerCase();
        while (left < right) {
            while (left < right && !Character.isDigit(s.charAt(left)) && !Character.isLetter(s.charAt(left))) left++;
            while (left < right && !Character.isDigit(s.charAt(right)) && !Character.isLetter(s.charAt(right))) right--;
            if (left < right && s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
