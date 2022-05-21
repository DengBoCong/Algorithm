package com.dbc;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int point = 0, cur = 0;
        while (cur < nums.length) {
            while (cur < nums.length && nums[cur] == 0) cur++;
            if (cur < nums.length) {
                int temp = nums[point];
                nums[point] = nums[cur];
                nums[cur] = temp;
                cur++;
                point++;
            }
        }
    }
}
