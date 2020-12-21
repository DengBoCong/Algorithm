package com.dbc.leecode.Algorithm.Solution1_10;

public class Solution10 {
    public static boolean isPalindromeS1(int x) {
        if(x < 0) return false;
        String str = x + "";
        int left = 0;
        int right = str.length() - 1;
        while (left < right){
            if(str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeS2(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber/10;
    }
}
