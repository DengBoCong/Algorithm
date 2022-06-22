package com.dbc.code;

public class Candy {
    public int candy(int[] ratings) {
        int res = 1, point = 0, pre = 1, max = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                res += pre;
                point = i;
                max = pre;
            } else {
                res += i - point + 1 > max ? i - point + 1 : i - point;
                pre = 1;
            }
        }
        return res;
    }
}
