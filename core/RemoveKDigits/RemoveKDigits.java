package com.dbc;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < num.length(); i++) {
            while (!stack.isEmpty() && k > 0 && (stack.peekLast() - '0') > (num.charAt(i) - '0')) {
                stack.pollLast();
                k--;
            }
            stack.addLast(num.charAt(i));
        }
        while (k > 0) {
            stack.pollLast();
            k--;
        }
        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        while (!stack.isEmpty()) {
            char digit = stack.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }
        return ret.length() == 0 ? "0" : ret.toString();
    }
}
