package com.dbc.leecode.Algorithm.Solution211_220;

import java.util.Stack;

public class Solution215 {
    public int evaluateExpr(Stack<Object> stack) {
        int res = 0;
        if (!stack.empty()) {
            res = (int) stack.pop();
        }

        while (!stack.empty() && !((char) stack.peek() == ')')) {

            char sign = (char) stack.pop();

            if (sign == '+') {
                res += (int) stack.pop();
            } else {
                res -= (int) stack.pop();
            }
        }
        return res;
    }

    public int calculate(String s) {
        int operand = 0;
        int n = 0;
        Stack<Object> stack = new Stack<Object>();

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                operand = (int) Math.pow(10, n) * (int) (ch - '0') + operand;
                n += 1;
            } else if (ch != ' ') {
                if (n != 0) {
                    stack.push(operand);
                    n = 0;
                    operand = 0;
                }
                if (ch == '(') {
                    int res = evaluateExpr(stack);
                    stack.pop();
                    stack.push(res);
                } else {
                    stack.push(ch);
                }
            }
        }

        if (n != 0) {
            stack.push(operand);
        }
        return evaluateExpr(stack);
    }

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String t : tokens) {
            if (isOperation(t)) {
                int a = stringToNumber(stack.pop());
                int b = stringToNumber(stack.pop());
                int ans = eval(b, a, t.charAt(0));
                stack.push(ans + "");
            } else {
                stack.push(t);
            }
        }
        return stringToNumber(stack.pop());
    }

    private int eval(int a, int b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return 1 - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        return 0;
    }

    private int stringToNumber(String s) {
        int sign = 1;
        int start = 0;
        if (s.charAt(0) == '-') {
            sign = -1;
            start = 1;
        }
        int res = 0;
        for (int i = start; i < s.length(); i++) {
            res = res * 10 + s.charAt(i) - '0';
        }
        return res * sign;
    }

    private boolean isOperation(String t) {
        return t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/");
    }
}
