package com.dbc.leecode.Algorithm.Solution221_230;

public class Solution229 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];

        res[len - 1] = 1;
        for (int i = len - 2; i >=0; i--) {
            res[i] = nums[i + 1] * res[i + 1];
        }

        int temp = nums[0];
        for (int i = 1; i < len; i++) {
            res[i] = res[i] *temp;
            temp *= nums[i];
        }

        return res;
    }
}
