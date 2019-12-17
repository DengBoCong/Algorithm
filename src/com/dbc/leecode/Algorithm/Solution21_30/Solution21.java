package com.dbc.leecode.Algorithm.Solution21_30;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution21 {
    public static boolean isValidS1(String s) {
        if(s.equals("")) return true;

        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');map.put(')', '(');
        map.put('[', ']');map.put(']', '[');
        map.put('{', '}');map.put('}', '{');

        char v[] = new char[s.length()];
        int index = 0;
        for (int i = 0; i < s.length(); i++){
            if(index == 0) {
                v[index] = s.charAt(i);
                index++;
            }else if(s.charAt(i) == map.get(v[index - 1])) index--;
            else {
                v[index] = s.charAt(i);
                index++;
            }
        }

        if(index != 0) return false;
        else return true;
    }

    // Hash table that takes care of the mappings.
    private HashMap<Character, Character> mappings;

    public Solution21() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public boolean isValidS2(String s) {

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (this.mappings.containsKey(c)) {
                char topElement = stack.empty() ? '#' : stack.pop();
                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
