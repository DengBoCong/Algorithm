package com.dbc.code;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int revertedNum = 0;
        while (revertedNum < x) {
            revertedNum = revertedNum * 10 + x % 10;
            x /= 10;
        }
        return revertedNum == x || x == revertedNum / 10;
    }
}
