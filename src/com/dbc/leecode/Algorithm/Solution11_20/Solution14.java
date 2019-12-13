package com.dbc.leecode.Algorithm.Solution11_20;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution14 {
    public static int romanToIntS1(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);map.put("IV", 4);
        map.put("V", 5);map.put("X",10);
        map.put("IX",9);map.put("XL",40);
        map.put("L",50);map.put("C",100);
        map.put("XC",90);map.put("D",500);
        map.put("CD",400);map.put("M",1000);
        map.put("CM",900);

        int result = 0;
        for(int i = 0; i < s.length(); i++){
            Integer front = map.get(s.substring(i, i + 1));
            Integer back = null;
            if(i != s.length() - 1){
                back = map.get(s.substring(i, i + 2));
            }
            if(back != null){
                result += back;
                i += 1;
            }else{
                result += front;
            }
        }
        return result;
    }
}
