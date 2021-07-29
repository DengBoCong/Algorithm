package com.dbc.algorithm.Array;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int key = nums[0], value = 1;
        for (int i = 1; i < nums.length; i++) {
            if (key == nums[i]) {
                value++;
            } else if (value == 0) {
                key = nums[i];
                value = 1;
            } else {
                value--;
            }
        }
        return key;
    }
}
