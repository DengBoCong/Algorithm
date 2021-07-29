package com.dbc.leecode.Algorithm.Solution151_160;

import java.util.Stack;

public class Solution151 {
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder temp = new StringBuilder();
        s += " ";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (temp.length() != 0) {
                    stack.push(temp.toString());
                    temp = new StringBuilder();
                }
            } else {
                temp.append(s.charAt(i));
            }
        }
        if (stack.isEmpty()) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        res.append(stack.pop());
        while (!stack.isEmpty()) {
            res.append(" ");
            res.append(stack.pop());
        }
        return res.toString();
    }
}
