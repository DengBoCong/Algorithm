package com.dbc;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                StringBuilder subStr = new StringBuilder();
                while (!stack.isEmpty() && !stack.peek().equals("[")) subStr.insert(0, stack.pop());
                if (!stack.isEmpty()) {
                    stack.pop();
                    StringBuilder numStr = new StringBuilder();
                    while (!stack.isEmpty() && stack.peek().length() == 1 && Character.isDigit(stack.peek().charAt(0))) numStr.insert(0, stack.pop());
                    int num = Integer.parseInt(numStr.toString());
                    for (int j = 0; j < num; j++) stack.add(subStr.toString());
                }
            } else {
                stack.add(Character.toString(s.charAt(i)));
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }
        return res.toString();
    }
}
