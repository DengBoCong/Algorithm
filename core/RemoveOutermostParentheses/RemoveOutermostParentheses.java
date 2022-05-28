package com.dbc;

import java.util.Stack;

public class RemoveOutermostParentheses {
    public String removeOuterParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.add(i);
            else {
                int preIndex = stack.pop();
                if (stack.isEmpty()) res.append(s.substring(preIndex + 1, i));
            }
        }
        return res.toString();
    }
}
