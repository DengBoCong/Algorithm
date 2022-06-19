package com.dbc.code;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int left = nums.length - 1, right = nums.length - 1;
        while (left >= 0) {
            if (nums[left] + left >= right) right = left;
            left--;
        }
        return right == 0;
    }
}
