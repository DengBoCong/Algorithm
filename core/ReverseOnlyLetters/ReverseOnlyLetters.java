package com.dbc;

public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String s) {
        int left = 0, right = s.length() - 1;
        char[] res = s.toCharArray();
        while (left < right) {
            while (left < right && !Character.isLetter(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetter(s.charAt(right))) {
                right--;
            }
            char temp = res[left];
            res[left] = res[right];
            res[right] = temp;

            left++;
            right--;
        }
        return new String(res);
    }
}
