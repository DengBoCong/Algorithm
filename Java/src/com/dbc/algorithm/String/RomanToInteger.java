package com.dbc.algorithm.String;

public class RomanToInteger {
    public int romanToInt(String s) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int start = 0, result = 0;
        for (int i = 0; i < values.length; i++) {
            int length = symbols[i].length();
            int end = start + length;
            while (s.substring(start, end).equals(symbols[i])) {
                result += values[i];
                start = end;
                end = start + length;
            }
        }

        return result;
    }
}
