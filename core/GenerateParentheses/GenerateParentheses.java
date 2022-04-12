package com.dbc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>(){{
            add("()");
        }};
        if (n == 1) return res;
        for (int i = 1; i < n; i++) {
            Map<String, Boolean> remain = new HashMap<>();
            List<String> tempRes = new ArrayList<>();
            for (String item : res) {
                if (remain.getOrDefault("()" + item, true)) {
                    tempRes.add("()" + item);
                    remain.put("()" + item, false);
                }
                if (remain.getOrDefault(item + "()", true)) {
                    tempRes.add(item + "()");
                    remain.put(item + "()", false);
                }
                for (int j = 1; j < item.length(); j++) {
                    String comStr = item.substring(0, j) + "()" + item.substring(j, item.length());
                    if (remain.getOrDefault(comStr, true)) {
                        tempRes.add(comStr);
                        remain.put(comStr, false);
                    }
                }
            }
            res = tempRes;
        }
        return res;
    }
}
