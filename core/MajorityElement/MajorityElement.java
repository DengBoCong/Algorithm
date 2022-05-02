package com.dbc;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int num = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                count = 1;
                num = nums[i];
            } else if (num == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return num;
    }
}
