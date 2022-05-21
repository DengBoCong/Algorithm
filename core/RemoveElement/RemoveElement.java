package com.dbc;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int point = 0, cur = 0;
        while (cur < nums.length) {
            if (nums[cur] != val) {
                int temp = nums[cur];
                nums[cur] = nums[point];
                nums[point] = temp;
                point++;
            }
            cur++;
        }
        return point;
    }
}
