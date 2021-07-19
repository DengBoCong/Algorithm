package com.dbc.algorithm.ReferOffer;

import java.util.Arrays;

public class BuKePaiZhongDeShunZiLcof {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) count++;
            else if (nums[i + 1] - 1 - nums[i] < 0) {
                return false;
            } else {
                count -= nums[i + 1] - 1 - nums[i];
            }
        }
        return count >= 0;
    }
}
