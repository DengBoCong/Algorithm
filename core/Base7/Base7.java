package com.dbc;

public class Base7 {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }

        StringBuffer res = new StringBuffer();
        int temp = Math.abs(num);
        while (temp != 0) {
            res.append(temp % 7);
            temp /= 7;
        }

        return num >= 0 ? res.reverse().toString() : res.append("-").reverse().toString();
    }
}
