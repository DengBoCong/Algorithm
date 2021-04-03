package com.dbc.algorithm.ReferOffer;

public class BaShuZiFanYiChengZiFuChuanLcof {
    private int res = 0;
    public int translateNum(int num) {
        String strNums = "" + num;
        dfs(strNums, 0, strNums.length());
        return res;
    }

    public void dfs(String strNum, int point, int length) {
        if (point == length) {
            res++;
            return;
        }
        if (point < length - 1 && strNum.charAt(point) != '0' && Integer.parseInt(strNum.substring(point, point + 2)) < 26) {
            dfs(strNum, point + 2, length);
        }
        dfs(strNum, point + 1, length);
    }
}
