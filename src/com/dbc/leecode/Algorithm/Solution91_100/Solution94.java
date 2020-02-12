package com.dbc.leecode.Algorithm.Solution91_100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-12 15:38
 **/
public class Solution94 {
    int n;
    String s;
    LinkedList<String> segments = new LinkedList<>();
    ArrayList<String> output = new ArrayList<>();

    public boolean valid(String segment){
        int m = segment.length();
        if (m > 3)
            return false;
        return (segment.charAt(0) != '0') ? (Integer.valueOf(segment) <= 255) : (m == 1);
    }

    public void update_output(int curr_pos){
        String segment = s.substring(curr_pos + 1, n);
        if (valid(segment)){
            segments.add(segment);
            output.add(String.join(".", segments));
            segments.removeLast();
        }
    }

    public void backtrack(int prev_pos, int dots){
        int max_pos = Math.min(n - 1, prev_pos + 4);
        for (int curr_pos = prev_pos + 1; curr_pos < max_pos; curr_pos++){
            String segment = s.substring(prev_pos + 1, curr_pos + 1);
            if (valid(segment)){
                segments.add(segment);
                if (dots - 1 == 0)
                    update_output(curr_pos);
                else
                    backtrack(curr_pos, dots - 1);
                segments.removeLast();
            }
        }
    }
    public List<String> restoreIpAddresses(String s){
        n = s.length();
        this.s = s;
        backtrack(-1, 3);
        return output;
    }
}
