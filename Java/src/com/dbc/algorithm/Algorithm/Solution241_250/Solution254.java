package com.dbc.leecode.Algorithm.Solution241_250;

import java.util.ArrayList;
import java.util.List;

public class Solution254 {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        addOperatorsHelper(num, target, result, new StringBuilder(), 0, 0, 0);
        return result;
    }

    private void addOperatorsHelper(String num, int target, List<String> result, StringBuilder path, int start, long eval, long pre) {
        if (start == num.length()) {
            if (target == eval) {
                result.add(path.toString());
            }
            return;

        }
        for (int i = start; i < num.length(); i++) {
            // 数字不能以 0 开头
            if (num.charAt(start) == '0' && i > start) {
                break;
            }
            long cur = Long.parseLong(num.substring(start, i + 1));
            int len = path.length();
            if (start == 0) {
                addOperatorsHelper(num, target, result, path.append(cur), i + 1, cur, cur);
                path.setLength(len);
            } else {

                // 加当前值
                addOperatorsHelper(num, target, result, path.append("+").append(cur), i + 1, eval + cur, cur);
                path.setLength(len);
                // 减当前值
                addOperatorsHelper(num, target, result, path.append("-").append(cur), i + 1, eval - cur, -cur);
                path.setLength(len);
                // 乘当前值
                addOperatorsHelper(num, target, result, path.append("*").append(cur), i + 1, eval - pre + pre * cur,
                        pre * cur);
                path.setLength(len);
            }
        }
    }
}
