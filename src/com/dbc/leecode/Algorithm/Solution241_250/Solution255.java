package com.dbc.leecode.Algorithm.Solution241_250;

public class Solution255 {
    public void moveZeroes(int[] nums) {
        int cur = 0, prev = 0;
        for (int num : nums) {
            if (num != 0 && prev != cur) {
                nums[cur] = nums[cur] ^ nums[prev];
                nums[prev] = nums[cur] ^ nums[prev];
                nums[cur] = nums[cur] ^ nums[prev];
                prev++;
            }else if (num != 0 && prev == cur) prev++;
            cur++;
        }
    }
}
