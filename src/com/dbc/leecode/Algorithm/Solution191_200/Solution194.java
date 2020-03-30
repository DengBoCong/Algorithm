package com.dbc.leecode.Algorithm.Solution191_200;

import java.util.HashMap;
import java.util.Map;

public class Solution194 {
    public boolean isIsomorphicS1(String s, String t) {
        return isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s);

    }

    private boolean isIsomorphicHelper(String s, String t) {
        int n = s.length();
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) {
                    return false;
                }
            } else {
                map.put(c1, c2);
            }
        }
        return true;
    }

    public boolean isIscomorphic(String s, String t){
        int n = s.length();
        int[] mapS = new int[128];
        int[] mapT = new int[128];
        for (int i = 0; i < n; i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (mapS[c1] != mapT[c2]){
                return false;
            }else {
                if (mapS[c1] == 0){
                    mapS[c1] = i + 1;
                    mapT[c2] = i + 1;
                }
            }
        }
        return true;
    }
}
