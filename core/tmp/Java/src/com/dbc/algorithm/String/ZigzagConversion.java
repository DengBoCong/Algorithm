package com.dbc.algorithm.String;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {
    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int row = Math.min(numRows, s.length());
        List<StringBuffer> remain = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            remain.add(new StringBuffer());
        }

        int goDown = 0;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            remain.get(goDown).append(s.charAt(i));
            if (goDown == 0 || goDown == row - 1) {
                flag = !flag;
            }
            goDown += flag ? 1 : -1;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuffer buffer : remain) {
            result.append(buffer);
        }
        return result.toString();
    }
}
