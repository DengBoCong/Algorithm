package com.dbc;

import java.util.Stack;

public class BasicCalculatorII {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char preOp = '+';
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + (s.charAt(i) - '0');
            }
            if (i == s.length() - 1 || s.charAt(i) == '-' || s.charAt(i) == '+' || s.charAt(i) == '*' || s.charAt(i) == '/') {
                if (preOp == '+') stack.add(num);
                else if (preOp == '-') stack.add(-num);
                else if (preOp == '*') stack.add(num * stack.pop());
                else stack.add(stack.pop() / num);
                num = 0;
                preOp = s.charAt(i);
            }
        }
        int res = 0;
        while (!stack.isEmpty()) res += stack.pop();
        return res;
    }
}
