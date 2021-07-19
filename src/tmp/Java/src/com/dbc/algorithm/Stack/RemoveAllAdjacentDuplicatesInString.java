package com.dbc.algorithm.Stack;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String S) {
        StringBuffer stack = new StringBuffer();
        for (int i = 0; i < S.length(); i++) {
            if (stack.length() != 0 && S.charAt(i) == stack.charAt(stack.length() - 1)) {
                stack.deleteCharAt(stack.length() - 1);
            } else {
                stack.append(S.charAt(i));
            }
        }
        return stack.toString();
    }
}
