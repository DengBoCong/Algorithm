package com.dbc.leecode.Algorithm.Solution11_20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2019-12-15 22:27
 **/
public class Solution18 {
    public static List<String> letterCombinationsS1(String digits) {
        String strs[] = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> result = new ArrayList<>();
        if(digits.equals("")) return result;

        for (int i = 0; i < digits.length(); i++){
            List<String> temp = new ArrayList<>();
            String str = strs[Integer.parseInt(digits.charAt(i)+"")-2];
            if(i == 0){
                for (int j = 0; j < str.length(); j++){
                    result.add(str.charAt(j)+"");
                }
            }else{
                for(String sub : result){
                    for (int j = 0; j < str.length(); j++){
                        temp.add(sub+str.charAt(j));
                    }
                }
                result = temp;
            }
        }
        return result;
    }

    static Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    static List<String> output = new ArrayList<String>();

    public static void backtrack(String combination, String next_digits) {
        // if there is no more digits to check
        if (next_digits.length() == 0) {
            // the combination is done
            output.add(combination);
        }
        // if there are still digits to check
        else {
            // iterate over all letters which map
            // the next available digit
            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                // append the current letter to the combination
                // and proceed to the next digits
                backtrack(combination + letter, next_digits.substring(1));
            }
        }
    }

    public static List<String> letterCombinationsS2(String digits) {
        if (digits.length() != 0)
            backtrack("", digits);
        return output;
    }
}
