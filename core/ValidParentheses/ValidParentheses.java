package com.dbc;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && ((stack.peek() == '(' && s.charAt(i) == ')') || (stack.peek() == '{' && s.charAt(i) == '}') || (stack.peek() == '[' && s.charAt(i) == ']')))
                stack.pop();
            else stack.push(s.charAt(i));
        }
        return stack.isEmpty();
    }
}
