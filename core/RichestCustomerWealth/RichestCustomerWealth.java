package com.dbc;

public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int res = 0;
        for (int[] custom : accounts) {
            int temp = 0;
            for (int mon : custom) temp += mon;
            res = Math.max(res, temp);
        }
        return res;
    }
}
