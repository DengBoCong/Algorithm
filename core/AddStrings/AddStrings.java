package com.dbc;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        String res = "";
        int remain = 0;
        int left = num1.length() - 1, right = num2.length() - 1;
        while (left >= 0 && right >= 0) {
            int temp = (num1.charAt(left) - '0') + (num2.charAt(right) - '0') + remain;
            remain = temp / 10;
            res = "" + (temp % 10) + res;

            left--;
            right--;
        }
        int point = Math.max(left, right);
        String num = left >= 0 ? num1 : num2;
        while (point >= 0) {
            int temp = (num.charAt(point) - '0') + remain;
            remain = temp / 10;
            res = "" + (temp % 10) + res;
            point--;
        }

        if (remain != 0) res = "" + remain + res;
        return res;
    }
}
