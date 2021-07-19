package com.dbc.algorithm.String;

import java.util.HashMap;
import java.util.Map;

public class StringToIntegerAtoi {
    private String state = "start";
    private long result = 0;
    private int flag = 1;
    private Map<String, String[]> table = new HashMap<String, String[]>(){{
        put("start", new String[]{"start", "signed", "in_number", "end"});
        put("signed", new String[]{"end", "end", "in_number", "end"});
        put("in_number", new String[]{"end", "end", "in_number", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};

    private int get_col(char c) {
        if (c == ' ') {
            return 0;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        return 3;
    }

    public void get(char c) {
        state = table.get(state)[get_col(c)];
        if ("in_number".equals(state)) {
            result = result * 10 + c - '0';
            result = flag == 1 ? Math.min(result, (long) Integer.MAX_VALUE) : Math.min(result, -(long) Integer.MIN_VALUE);
        } else if ("signed".equals(state)) {
            flag = c == '+' ? 1 : -1;
        }
    }

    public int myAtoi(String s) {
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            get(s.charAt(i));
        }
        return (int) (flag * result);
    }
}
