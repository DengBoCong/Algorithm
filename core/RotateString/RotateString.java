package com.dbc;

public class RotateString {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        for (int i = 0; i < s.length(); i++) {
            int left = i, right = 0;
            while (right < s.length()) {
                if (s.charAt(left) != goal.charAt(right)) break;
                left = (left + 1) % s.length();
                right++;
            }
            if (right == s.length()) return true;
        }
        return false;
    }
}
