package com.dbc;

public class GreatestCommonDivisorOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        int candi = getGcd(str1.length(), str2.length());
        if ((str1 + str2).equals(str2 + str1)) {
            return str1.substring(0, candi);
        }
        return "";
    }

    private int getGcd(int a, int b) {
        int remain = a % b;
        while (remain != 0) {
            a = b;
            b = remain;
            remain = a % b;
        }
        return b;
    }
}
