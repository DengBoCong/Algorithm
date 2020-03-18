package com.dbc.leecode.Algorithm.Solution171_180;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution178 {
    public List<String> findRepeatedDnaSequences(String s){
        int len = s.length();
        if (len == 0 || len < 10) {
            return new ArrayList<>();
        }
        Set<String> res = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        int key = 0;
        char[] array = s.toCharArray();
        for (int i = 0; i < 10; i++) {
            key <<= 3;
            key |= (array[i] & 7);
        }
        set.add(key);
        for (int i = 10; i < len; i++) {
            key <<= 3;
            key |= (array[i] & 7);
            key &= 0x3fffffff;
            if (set.contains(key)) {
                res.add(s.substring(i - 9, i + 1));
            } else {
                set.add(key);
            }

        }
        return new ArrayList<>(res);
    }
}
