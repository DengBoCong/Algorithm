package com.dbc.algorithm.String;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        StringBuffer res = new StringBuffer();
        String[] temp = s.trim().split(" ");
        for (int i = temp.length - 1; i >= 0; i--) {
            if (temp[i].equals("")) continue;
            res.append(temp[i] + " ");
        }
        return res.toString().trim();
    }
}
