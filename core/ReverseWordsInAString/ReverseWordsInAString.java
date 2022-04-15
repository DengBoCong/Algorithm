package com.dbc;

import java.util.ArrayList;
import java.util.List;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        List<String> res = new ArrayList<>();
        int cur = s.length() - 1;
        while (cur >= 0) {
            while (cur >= 0 && s.charAt(cur) == ' ') cur--;
            if (cur == -1) break;
            int point = cur;
            while (point >= 0 && s.charAt(point) != ' ') point--;
            res.add(s.substring(point + 1, cur + 1));
            cur = point;
        }
        StringBuffer temp = new StringBuffer();
        temp.append(res.get(0));
        for (int i = 1; i < res.size(); i++) {
            temp.append(" ");
            temp.append(res.get(i));
        }
        return temp.toString();
    }
}
