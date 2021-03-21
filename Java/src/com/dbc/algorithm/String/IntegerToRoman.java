package com.dbc.algorithm.String;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < symbols.length; i++) {
            int temp = num / values[i];
            for (int j = 0; j < temp; j++) {
                result.append(symbols[i]);
            }
            num = num % values[i];
            if (num == 0) {
                break;
            }
        }
        return result.toString();
    }
}
