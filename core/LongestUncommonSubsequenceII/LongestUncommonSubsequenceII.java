package com.dbc;

public class LongestUncommonSubsequenceII {
    public boolean isSeq(String x, String y) {
        int index = 0;
        for (int i = 0; i < y.length() && index < x.length(); i++) {
            if (x.charAt(index) == y.charAt(i)) {
                index++;
            }
        }
        return index == x.length();
    }

    public int findLUSlength(String[] strs) {
        int res = -1;
        for (int i = 0, j; i < strs.length; i++) {
            for (j = 0; j < strs.length; j++) {
                if (i == j) continue;
                if (isSeq(strs[i], strs[j])) break;
            }
            if (j == strs.length) {
                res = Math.max(res, strs[i].length());
            }
        }
        return res;
    }
}
